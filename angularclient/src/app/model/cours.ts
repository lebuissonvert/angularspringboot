import { Eleve } from '../model/eleve';
import { TypeEleve } from '../model/type-eleve';

export class Cours {
  adresse: string;
  eleves: Eleve[];
  end: Date;
  id: number;
  nbCavalieres: number;
  nbCavaliers: number;
  start: Date;
  title: string;
  niveau: string;
  prof: string;
  ville: string;
}
