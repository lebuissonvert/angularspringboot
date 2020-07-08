package app.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserFilterDTO {
    @JsonProperty("value")
    private String value;

    @JsonProperty("matchMode")
    private String matchMode;

    public UserFilterDTO(String value, String matchMode) {
        this.value = value;
        this.matchMode = matchMode;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMatchMode() {
        return matchMode;
    }

    public void setMatchMode(String matchMode) {
        this.matchMode = matchMode;
    }
}
