import React, { useEffect, useState } from 'react';
import { Flight } from './Flight';

import axios from 'axios';


export interface FlightTableProps {
  flights: Flight[]; // Now the component expects an array of flights passed as a prop
}
  
const Table: React.FC<FlightTableProps> = ({ flights }) => {
  if (!flights || flights.length === 0) {
      return 
  }

    return (
        <div className="mt-3">
            <h2 className="text-2xl font-semibold text-gray-800">Available Flights</h2>
            <table className="min-w-full bg-white shadow-md rounded mt-4">
                <thead>
                    <tr className="bg-gray-200 text-gray-600 uppercase text-sm leading-normal">
                        <th className="py-3 px-6 text-left">Origin</th>
                        <th className="py-3 px-6 text-left">Destination</th>
                        <th className="py-3 px-6 text-left">Date</th>
                        <th className="py-3 px-6 text-left">Price</th>
                        <th className="py-3 px-6 text-left">Baggage</th>
                        <th className="py-3 px-6 text-left">Class</th>
                    </tr>
                </thead>
                <tbody className="text-gray-600 text-sm font-light">
                    {flights && flights.map((flight, index) => (
                        <tr key={index} className="border-b border-gray-200 hover:bg-gray-100">
                            <td className="py-3 px-6 text-left whitespace-nowrap">{flight.origin}</td>
                            <td className="py-3 px-6 text-left">{flight.destination}</td>
                            <td className="py-3 px-6 text-left">{new Date(flight.date).toLocaleDateString()}</td>
                            <td className="py-3 px-6 text-left">${flight.price.toFixed(2)}</td>
                            <td className="py-3 px-6 text-left">{flight.baggage}</td>
                            <td className="py-3 px-6 text-left">{flight.clase}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

  
  export default Table;
