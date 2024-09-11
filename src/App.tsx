import { useState, useEffect } from 'react'
import Table from './components/Table'
import SearchForm from './components/SearchForm'
import axios from 'axios';
import { Flight } from './components/Flight'
import 'tailwindcss/tailwind.css';

const App: React.FC = () => {
  // Los parámetros de búsqueda se manejarán aquí en el estado del componente principal
  const [searchParams, setSearchParams] = useState({
    startDate: '',
    endDate: '',
    origin: '',
    destination: '',
    maxPrice: '',
    baggage: '', 
    maxPax: '', 
    clase: ''
  });
  var url = '';
  const [flights, setFlights] = useState<Flight[]>([]);

  const [filtersEnabled, setFiltersEnabled] = useState(false); // Estado para habilitar/deshabilitar filtros
  const [isLoadingFilters, setIsLoadingFilters] = useState(false);
  const [uniqueOrigins, setUniqueOrigins] = useState<string[]>([]);
  const [uniqueDestinations, setUniqueDestinations] = useState<string[]>([]);
  const [uniqueBaggage, setUniqueBaggage] = useState<string[]>([]);
  const [uniqueClases, setUniqueClases] = useState<string[]>([]);


  

  // Manejador para la búsqueda de vuelos basado en fechas
  const handleDateSearch = async (startDate: string, endDate: string) => {
    // Actualizamos las fechas en los parámetros de búsqueda
    setSearchParams((prev) => ({ ...prev, startDate, endDate, origin: '', destination:'', maxPrice:'', baggage: '',  maxPax: '', clase: ''}));

    // Deshabilitamos los filtros mientras se cargan los datos
    setFiltersEnabled(false);
    setIsLoadingFilters(true);

    if(startDate && endDate != ''){
      try {

        const params = new URLSearchParams();
        if (startDate) params.append("startDate", startDate);
        if (endDate) params.append("endDate", endDate);

        url = `http://localhost:8081/api/flights/search?${params.toString()}`;
        console.log("URL: ",url)

        // Hacemos la solicitud al backend para obtener los orígenes y destinos disponibles en el rango de fechas
        const response = await axios.get(url);
        console.log("Flights by date only: ",flights);
        setFlights(response.data);
        // Habilitamos los filtros una vez que los datos han sido cargados
        setFiltersEnabled(true);
      } catch (error) {
        console.error('Error al cargar los orígenes y destinos:', error);
      } finally {
        setIsLoadingFilters(false);
      }
    };
    }
    


   // Manejador para la búsqueda final (con filtros aplicados)
   const handleFinalSearch = async (startDate: string, endDate: string, origin: string, destination: string, maxPrice: string, baggage: string, maxPax: string, clase: string ) => {
    // Actualizamos los parámetros de búsqueda finales
    setSearchParams((prev) => ({
      ...prev,
      origin,
      destination,
      maxPrice,
      startDate, 
      endDate,
      baggage,
      maxPax,
      clase
    }));
    if(startDate && endDate != ''){
      try {
        const params = new URLSearchParams();
        if (startDate) params.append("startDate", startDate);
        if (endDate) params.append("endDate", endDate);
        if (origin) params.append("origin", origin);
        if (destination) params.append("destination", destination);
        if (maxPrice) params.append("maxPrice", maxPrice);
        if (baggage) params.append("baggage", baggage);
        if (maxPax) params.append("maxPax", maxPax);
        if (clase) params.append("clase", clase);

        url = `http://localhost:8081/api/flights/search?${params.toString()}`;
        console.log("URL: ",url)

        // Hacemos la solicitud al backend para obtener los orígenes y destinos disponibles en el rango de fechas
        const response = await axios.get(url);
  
        setFlights(response.data);
        // Habilitamos los filtros una vez que los datos han sido cargados
        setFiltersEnabled(true);
      } catch (error) {
        console.error('Error al cargar los orígenes y destinos:', error);
      }
      console.log("Flights app: ",flights);
  
    }
  
  };

  useEffect(() => {
    // Extraer destinos únicos cuando los vuelos se cargan
    const destinations = Array.from(new Set(flights.map(flight => flight.destination)));
    setUniqueDestinations(destinations);

    const origins = Array.from(new Set(flights.map(flight => flight.origin)));
    setUniqueOrigins(origins);

    const baggage = Array.from(new Set(flights.map(flight => flight.baggage)));
    setUniqueBaggage(baggage);

    const clases = Array.from(new Set(flights.map(flight => flight.clase)));
    setUniqueClases(clases);

    console.log("Search params: ", searchParams);
}, [flights]);

  return (
    <div className="min-h-screen bg-gray-100 p-20 max-w-4xl mx-auto">
        <h1 className="text-4xl font-bold text-gray-800 text-center mb-5">Flight Search</h1>
        <hr className="border-t-2 border-gray-300 mb-5" />
        <SearchForm
            onDateSearch={handleDateSearch}
            onFinalSearch={handleFinalSearch}
            filtersEnabled={filtersEnabled}
            uniqueOrigins={uniqueOrigins}
            uniqueDestinations={uniqueDestinations}
            uniqueBaggage={uniqueBaggage}
            uniqueClases={uniqueClases}
            isLoadingFilters={isLoadingFilters}
        />
        <Table flights={flights} />
    </div>
);
};

export default App;
