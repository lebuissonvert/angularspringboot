package app.controller;

import app.DTO.*;
import app.entity.Document;
import app.service.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@org.springframework.web.bind.annotation.RestController
@CrossOrigin(
        origins = "http://localhost:4200",
        allowedHeaders = "*",
        allowCredentials = "true"
)
public class RestController {

    @Autowired
    IUserService userService;
    @Autowired
    IIconeService iconeService;
    @Autowired
    IDocumentService documentService;
    @Autowired
    ICoursService coursService;
    @Autowired
    IEleveService eleveService;

    // application.properties
    @Value("${spring.jpa.show-sql}")
    private Boolean showSQL;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;

    // application.yml
    @Value("${app.yml.string}")
    private String _string;
    @Value("${app.yml.boolean.true}")
    private Boolean _true;
    @Value("${app.yml.boolean.false}")
    private Boolean _false;
    @Value("#{${app.yml.map.property-name}}")
    private Map<String,String> propertyMap;

    private ObjectMapper jacksonMapper = new ObjectMapper();

    @ResponseBody
    @RequestMapping("/")
    public String home() {
        return getHomeContent();
    }

    @ResponseBody
    @RequestMapping(value = "/insertTestUser", produces = "application/json")
    public String insertTestUser() throws JsonProcessingException {

        Integer userIdMax = userService.getMaxId();
        Integer id = userIdMax + 1;
        String login = "test_" + id;
        UserDTO userDTO = userService.createUser(login);

        return jacksonMapper.writeValueAsString(userDTO);
    }

    @ResponseBody
    @RequestMapping(
            value = "/createUser",
            produces = "application/json",
            method = RequestMethod.POST)
    public String createUser(@RequestBody String p_login)
            throws JsonProcessingException {

        if(p_login == null ||p_login.isEmpty()) {
            p_login = "test";
        }

        Integer userIdMax = userService.getMaxId();
        Integer id = userIdMax + 1;
        UserDTO userDTO = userService.createUser(p_login);

        return jacksonMapper.writeValueAsString(userDTO);
    }

    @ResponseBody
    @RequestMapping(
            value = "/ajouterEleveDansCours",
            produces = "application/json",
            method = RequestMethod.POST)
    public String ajouterEleveDansCours(@RequestBody EleveCoursDTO p_elevecours)
            throws JsonProcessingException {
        CoursDTO resultat = null;

        // eleve qu'on associera au cours
        Integer idEleve = null;

        // verif existence info eleves sans la casse
        List<EleveDTO> elevesDTO = eleveService.findEleveWithSameInformationNoCase(
                p_elevecours.getEleve().getNom(), p_elevecours.getEleve().getPrenom(),
                p_elevecours.getEleve().getMail(), p_elevecours.getEleve().getTel());

        if(elevesDTO!=null && !elevesDTO.isEmpty()) {
            // si il existe des infos sur cet utilisateur, on les récupère
            idEleve = elevesDTO.get(0).getId();
        } else {
            // si il n'existe aucune info avec cet utilisateur on le créé
            idEleve = eleveService.saveEleve(p_elevecours.getEleve()).getId();
        }

        // récupération + maj + save du cours
        if(p_elevecours.getIdcours() != null && idEleve != null) {
            coursService.linkEleveAndCours(idEleve, new Integer(p_elevecours.getIdcours()));
        }

        return jacksonMapper.writeValueAsString(resultat);
    }

    @ResponseBody
    @RequestMapping(
            value = "/saveUser",
            produces = "application/json",
            method = RequestMethod.POST)
    public String saveUser(@RequestBody UserDTO p_user)
            throws JsonProcessingException {
        UserDTO resultat = null;
        if(p_user != null) {
            resultat = userService.saveUser(p_user);
        }
        return jacksonMapper.writeValueAsString(resultat);
    }

    @ResponseBody
    @RequestMapping(
            value = "/saveDocumentFull",
            consumes = "multipart/form-data",
            produces = "application/json",
            method = RequestMethod.POST,
            headers = "Content-Type= multipart/form-data")
    public String saveDocumentFull(
            @RequestParam("file") MultipartFile file,
            @RequestParam("idDocument") String idDocument,
            @RequestParam("codeDocument") String codeDocument)
            throws IOException {
        DocumentLightDTO resultat = null;
        if(file != null && idDocument!=null && !idDocument.isEmpty() && codeDocument!=null && !codeDocument.isEmpty()) {
            Document document = new Document();
            document.setIdDocument(Integer.parseInt(idDocument));
            document.setCodeDocument(codeDocument);
            document.setDocument(file.getBytes());
            DocumentFullDTO documentFull = new DocumentFullDTO(document);
            resultat = documentService.saveDocumentFull(documentFull);
        }
        return jacksonMapper.writeValueAsString(resultat);
    }

    @ResponseBody
    @RequestMapping(
            value = "/createDocumentFull",
            consumes = "multipart/form-data",
            produces = "application/json",
            method = RequestMethod.POST,
            headers = "Content-Type= multipart/form-data")
    public String createDocumentFull(
            @RequestParam("file") MultipartFile file,
            @RequestParam("codeDocument") String codeDocument)
            throws IOException {
        DocumentLightDTO resultat = null;
        if(file != null && codeDocument!=null && !codeDocument.isEmpty()) {
            Document document = new Document();
            document.setIdDocument(null);
            document.setCodeDocument(codeDocument);
            document.setDocument(file.getBytes());
            DocumentFullDTO documentFull = new DocumentFullDTO(document);
            resultat = documentService.createDocumentFull(documentFull);
        }
        return jacksonMapper.writeValueAsString(resultat);
    }

    @ResponseBody
    @RequestMapping(value = "/showAllIcone", produces = "application/json")
    public String showAllIcone() throws JsonProcessingException {
        try {
            Iterable<IconeDTO> iconesDTO = iconeService.findAllByOrderByIdiconeAsc();
            return jacksonMapper.writeValueAsString(iconesDTO);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Exception while calling 'showAllIcone'", e);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getRewardsStats", produces = "application/json")
    public String getRewardsStats() throws JsonProcessingException {
        try {
            List<RewardsStatsDTO> rewardsStatsDTO = userService.getRewardsStats();
            return jacksonMapper.writeValueAsString(rewardsStatsDTO);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Exception while calling 'getRewardsStats'", e);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/showAllUser", produces = "application/json")
    public String showAllUser() throws JsonProcessingException {
        try {
            Iterable<UserDTO> usersDTO = userService.findAllByOrderByIdAsc();
            return jacksonMapper.writeValueAsString(usersDTO);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Exception while calling 'showAllUser'", e);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/showAllUserOrderByLogin", produces = "application/json")
    public String showAllUserOrderByLogin() throws JsonProcessingException {
        try {
            Iterable<UserDTO> usersDTO = userService.findAllByOrderByLoginAsc();
            return jacksonMapper.writeValueAsString(usersDTO);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Exception while calling 'showAllUserOrderByLogin'", e);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/showAllUserPaginated", produces = "application/json")
    public String showAllUserPaginated(
            @RequestParam(value = "page", defaultValue = "") String p_page,
            @RequestParam(value = "size", defaultValue = "") String p_pagesize,
            @RequestParam(value = "sortfield", defaultValue = "id") String p_sortField,
            @RequestParam(value = "sortorder", defaultValue = "1") String p_sortOrder,
            @RequestParam(value = "filters", defaultValue = "") String p_filters
    ) throws JsonProcessingException {
        try {
            if(!p_page.isEmpty() && !p_pagesize.isEmpty()) {
                int page_int = Integer.parseInt(p_page);
                int pagesize_int = Integer.parseInt(p_pagesize);
                String sortOrder = p_sortOrder.equals("-1") ? "DESC" : "ASC";
                String sortField = p_sortField.equals("undefined") ? "id" : p_sortField;
                PaginatedUserDTO paginatedUsersDTO = null;
                if(p_filters.isEmpty() || p_filters.equals("{}")) {
                    paginatedUsersDTO = userService.findAllPaginated(
                            page_int, pagesize_int, sortField, sortOrder);
                } else {
                    HashMap<String, UserFilterDTO> filterHashMap = toMapUserFilterDTO(p_filters);
                    paginatedUsersDTO = userService.findAllPaginated(
                            page_int, pagesize_int, sortField, sortOrder, filterHashMap);
                }
                return jacksonMapper.writeValueAsString(paginatedUsersDTO);
            }
            else {
                Iterable<UserDTO> usersDTO = userService.findAllByOrderByIdAsc();
                return jacksonMapper.writeValueAsString(usersDTO);
            }
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exception while calling 'showAllUserPaginated' : " + e.getMessage(), e);
        }
    }

    // {"login":{"value":"a","matchMode":"contains"},"eloranking":{"value":1500,"matchMode":"gt"}}
    private HashMap<String /*field*/, UserFilterDTO /*criteres*/> toMapUserFilterDTO(String p_filterStr) throws IOException {
        HashMap<String, UserFilterDTO> result = new HashMap<>();

        HashMap<String,Object> mainMap = new ObjectMapper().readValue(p_filterStr, HashMap.class);
        for(Map.Entry<String, Object> entry : mainMap.entrySet()) {
            LinkedHashMap<String, Object> subMap = (LinkedHashMap<String, Object>) mainMap.get(entry.getKey());
            result.put(
                    entry.getKey(),
                    new UserFilterDTO(subMap.get("value").toString(), subMap.get("matchMode").toString()));
        }

        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/showAllDocument", produces = "application/json")
    public String showAllDocument() throws JsonProcessingException {
        try {
            Iterable<DocumentLightDTO> documentsDTO = documentService.findAllLight();
            return jacksonMapper.writeValueAsString(documentsDTO);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exception while calling 'showAllDocument' : " + e.getMessage(), e);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getCoursById", produces = "application/json")
    public String getCoursById(
            @RequestParam(value = "id", defaultValue = "") String p_id)
            throws JsonProcessingException {
        try {
            if(!p_id.isEmpty()) {
                Integer int_id = Integer.parseInt(p_id);
                CoursDTO coursDTO = coursService.findById(int_id);
                return jacksonMapper.writeValueAsString(coursDTO);
            } else {
                throw new Exception("le paramètre 'id' est obligatoire.");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Exception while calling 'getCoursById'", e);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getTypesEleve", produces = "application/json")
    public String getTypesEleve() throws JsonProcessingException{
        try {
            List<TypeEleveDTO> typesEleveDTO = eleveService.findAllByOrderByIdtypeeleveAsc();
            return jacksonMapper.writeValueAsString(typesEleveDTO);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Exception while calling 'getTypesEleve'", e);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getCoursByMonthAndYear", produces = "application/json")
    public String getCoursByMonthAndYear(
            @RequestParam(value = "month", defaultValue = "") String p_month,
            @RequestParam(value = "year", defaultValue = "") String p_year)
            throws JsonProcessingException {
        try {
            if(!p_month.isEmpty() && !p_year.isEmpty()) {
                Integer int_month = Integer.parseInt(p_month);
                Integer int_year = Integer.parseInt(p_year);
                List<CoursDTO> coursDTO = coursService.getByYearAndMonth(int_year, int_month);
                return jacksonMapper.writeValueAsString(coursDTO);
            } else {
                throw new Exception("le paramètre 'id' est obligatoire.");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Exception while calling 'getCoursByMonthAndYear'", e);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/showOneDocument", produces = "application/json")
    public String showOneDocument(
            @RequestParam(value = "id", defaultValue = "") String p_id)
            throws JsonProcessingException {
        try {
            if(p_id != null && !p_id.isEmpty()) {
                Integer p_int_id = Integer.parseInt(p_id);
                DocumentLightDTO documentLightDTO = documentService.findLightById(p_int_id);
                return jacksonMapper.writeValueAsString(documentLightDTO);
            } else {
                throw new Exception("le paramètre 'id' est obligatoire.");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Exception while calling 'showOneDocument'", e);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/showOneUser", produces = "application/json")
    public String showOneUser(
            @RequestParam(value = "id", defaultValue = "") String p_id)
            throws JsonProcessingException {
        try {
            if(p_id != null && !p_id.isEmpty()) {
                Integer p_int_id = Integer.parseInt(p_id);
                UserDTO userDTO = userService.findById(p_int_id);
                return jacksonMapper.writeValueAsString(userDTO);
            } else {
                throw new Exception("le paramètre 'id' est obligatoire.");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Exception while calling 'showOneUser'", e);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/downloadDocument", produces = "application/x-octet-stream")
    public byte[] downloadDocument(
            @RequestParam(value = "id", defaultValue = "") String p_id)
            throws JsonProcessingException {
        try {
            if(p_id != null && !p_id.isEmpty()) {
                Integer p_int_id = Integer.parseInt(p_id);
                return documentService.getDocumentBlobById(p_int_id);
            } else {
                throw new Exception("le paramètre 'id' est obligatoire.");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Exception while calling 'downloadDocument'", e);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/showLoginLikeTest", produces = "application/json")
    public String showLoginLikeTest() throws JsonProcessingException {
        List<UserDTO> usersDTO = userService.findByLoginStartsWith("test");

        return jacksonMapper.writeValueAsString(usersDTO);
    }

    @ResponseBody
    @RequestMapping("/deleteAllUserStartingWithTest")
    public String deleteAllUserStartingWithTest() {
        boolean resultDeletion = userService.deleteByLoginStartsWith("test");
        return getHomeContent() + "<br><br>Deletion terminated with " + (resultDeletion ? "success" : "failure");
    }

    @ResponseBody
    @RequestMapping("/deleteAllUserStartingWithParam")
    public String deleteAllUserStartingWithParam(
            @RequestParam(value = "loginstartswith", defaultValue = "test") String p_loginlike) {
        String resultString = "";
        if(p_loginlike == null || p_loginlike.length()<3) {
            resultString = getHomeContent() + "<br><br><i>Aucune action effectuée, " +
                    "le service doit avoir le paramètre 'loginstartswith' avec au moins 3 caractères renseignés.</i>";
        } else {
            boolean resultDeletion = userService.deleteByLoginStartsWith(p_loginlike);
            resultString = getHomeContent() + "<br><br>Deletion (login like '"
                    + p_loginlike + "%') terminated with " + (resultDeletion ? "success" : "failure");
        }
        return resultString;
    }

    private String getHomeContent() {
        String html = "";
        html += "<ul>";
        html += " <li><a href='/insertTestUser'>Insert test user</a></li>";
        html += " <li><a href='/showAllUser'>Show All User</a></li>";
        html += " <li><a href='/showAllUserOrderByLogin'>Show All User, ordered by login</a></li>";
        html += " <li><a href='/showAllDocument'>Show All Document</a></li>";
        html += " <li><a href='/showLoginLikeTest'>Show All 'test%'</a></li>";
        html += " <li><a href='/deleteAllUserStartingWithTest'>Delete All test% User</a></li>";
        html += " <li><a href='/deleteAllUserStartingWithParam?loginstartswith=aa'>Delete All [param='loginstartswith']% User</a></li>";
        html += "</ul>";
        return html;
    }
}
