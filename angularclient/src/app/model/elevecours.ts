import { Eleve } from '../model/eleve';

export class Elevecours {
  eleve: Eleve;
  idcours: number;

  constructor(eleve: Eleve, idcours: number) {
    this.eleve = eleve;
    this.idcours = idcours;
  }
}
