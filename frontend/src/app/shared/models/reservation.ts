export class Reservation {
    id!: number;
    date_debut!: string;
    date_fin!: string;
    detail!: string;
    hebergementId!: number;
    userId!: string | null;
}
