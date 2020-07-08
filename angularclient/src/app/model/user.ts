import { Icone } from '../model/icone';

export class User {
    id: number;
    login: string;
    pass: string;
    eloranking: number;
    wins: number;
    loses: number;
    isABot: number;
    icone: Icone;
    horodatage: Date;

    constructor() {
        this.icone = new Icone();
      }
}
