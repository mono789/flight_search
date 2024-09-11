import React from 'react';



export interface Form {
    onDateSearch: (startDate: string, endDate: string) => void;
    onFinalSearch: (startDate: string, endDate: string, origin: string, destination: string, maxPrice: string, baggage: string, maxPax: string, clase: string ) => void;
    filtersEnabled: boolean;
    uniqueOrigins: string[];
    uniqueDestinations: string[];
    uniqueBaggage: string[];
    uniqueClases: string[];
    isLoadingFilters: boolean;
}