import { Component, OnInit } from '@angular/core';
import { CoursService } from '../service/cours.service';
import { EleveService } from '../service/eleve.service';
import { Cours } from '../model/cours';
import { Eleve } from '../model/eleve';
import { TypeEleve } from '../model/type-eleve';
import dayGridPlugin from '@fullcalendar/daygrid';
import timeGridPlugin from '@fullcalendar/timegrid';
import interactionPlugin from '@fullcalendar/interaction';
import { DatePipe } from '@angular/common';
import {DropdownModule} from 'primeng/dropdown';
import { Router } from '@angular/router';

@Component({
  selector: 'app-full-calendar',
  templateUrl: './full-calendar.component.html',
  styleUrls: ['./full-calendar.component.css'],
  providers: [DatePipe]
})
export class FullCalendarComponent implements OnInit {

  options: any;
  cours: Cours[] = [];
  selectedCours: Cours = new Cours();
  typesEleve: TypeEleve[] = [];
  nom: string = null;
  prenom: string = null;
  mail: string = null;
  tel: string = null;
  eleve: Eleve = new Eleve();
  displayDialog: boolean = false;

  constructor(private coursService: CoursService, private eleveService: EleveService,
              private datePipe: DatePipe, private router: Router) { }

  ngOnInit(): void {
    // appel de service pour init this.cours
    this.coursService.findByMonthAndYear(new Date().getMonth()+1, new Date().getFullYear()).subscribe(data => {
      this.cours = data;
    });

    // appel de service pour init this.typesEleve
    this.eleveService.findTypesEleves().subscribe(data => {
      this.typesEleve = data;
    });

    this.options = {
      plugins: [dayGridPlugin, timeGridPlugin, interactionPlugin],
      defaultDate: this.datePipe.transform(new Date(), 'yyyy-MM-dd'),
      header: {
          left: 'prev,next today',
          center: 'title',
          right: 'dayGridMonth,dayGridWeek,timeGridDay'
      },
      editable: true,
      dateClick: (e) =>  {
        let i = e;
      },
      eventClick: (e) =>  {
        let i = e;

        this.selectedCours.id = e.event.id;
        this.selectedCours.start = e.event.start;
        this.selectedCours.end = e.event.end;
        this.selectedCours.title = e.event.title;
        this.selectedCours.niveau = e.event.extendedProps.niveau;
        this.selectedCours.prof = e.event.extendedProps.prof;
        this.selectedCours.ville = e.event.extendedProps.ville;
        this.selectedCours.adresse = e.event.extendedProps.adresse;
        this.selectedCours.eleves = e.event.extendedProps.eleves;
        this.selectedCours.nbCavaliers = e.event.extendedProps.nbCavaliers;
        this.selectedCours.nbCavalieres = e.event.extendedProps.nbCavalieres;

        this.showDialog();
      }
    }
  }

  public getElevesInSelectedCoursOfTypeEleve(p_type: string):Eleve[] {
    let resultat: Eleve[] = [];
    if(this.selectedCours.eleves) {
      this.selectedCours.eleves.forEach((curEleve) => {
        if(curEleve.typeEleve.codetypeeleve.toLowerCase() == p_type.toLowerCase()) {
          resultat.push(curEleve);
        }
      });
    }
    return resultat;
  }

  enregistrerEleve() {
    this.coursService.ajouterEleveDansCours(this.eleve, this.selectedCours.id).subscribe(result => {
      // fermeture de la popin
      this.hideDialog();
      // maj de la view avec l'inscription
      this.coursService.findByMonthAndYear(new Date().getMonth()+1, new Date().getFullYear()).subscribe(data => {
        this.cours = data;
      });
    });
  }

  showDialog() {
    this.displayDialog = true;
    this.eleve = new Eleve();
  }

  hideDialog() {
    this.displayDialog = false;
    this.selectedCours = new Cours();
  }

}
