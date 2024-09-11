import React from 'react';

export interface Flight {
    id: number,
    origin: string,
    destination: string,
    date: Date,
    price: number,
    baggage: string,
    maxPax: number,
    clase: string
}

