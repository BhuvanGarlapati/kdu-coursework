export interface IRooms {
    id:           number;
    name:         string;
    costPerNight: string;
    currency:     string;
    addOns:       AddOn[];
}

export interface AddOn {
    name:     string;
    cost:     string;
    currency: string;
}
