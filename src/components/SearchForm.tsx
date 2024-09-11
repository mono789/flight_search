import React, { useState } from 'react';
import { Form } from './Form';

const SearchForm: React.FC<Form> = ({ onDateSearch, onFinalSearch, filtersEnabled, uniqueOrigins, uniqueDestinations, uniqueBaggage, uniqueClases, isLoadingFilters }) => {
  const [startDate, setStartDate] = useState('');
  const [endDate, setEndDate] = useState('');
  const [origin, setOrigin] = useState('');
  const [destination, setDestination] = useState('');
  const [maxPrice, setMaxPrice] = useState('');
  const [baggage, setBaggage] = useState('');
  const [maxPax, setMaxPax] = useState('');
  const [clase, setClase] = useState('');
  const [showOrigin, setShowOrigin] = useState(false);
  const [showDestination, setShowDestination] = useState(false);
  const [showMaxPrice, setShowMaxPrice] = useState(false);
  const [showMaxPax, setShowMaxPax] = useState(false);
  const [showBaggage, setShowBaggage] = useState(false);
  const [showClase, setShowClase] = useState(false);

  const handleDateSubmit = (e: React.FormEvent) => {
      e.preventDefault();
      if (startDate && endDate) {
        setOrigin('');
        setDestination('');
        setMaxPrice('');
        setBaggage('');
        setMaxPax('');
        setClase('');
        
        // Uncheck all filter checkboxes
        setShowOrigin(false);
        setShowDestination(false);
        setShowMaxPrice(false);
        setShowMaxPax(false);
        setShowBaggage(false);
        setShowClase(false);

        onDateSearch(startDate, endDate);
      }
  };

  const handleFinalSubmit = (e: React.FormEvent) => {
      e.preventDefault();
      onFinalSearch(startDate, endDate, origin, destination, maxPrice, baggage, maxPax, clase);
  };

  return (
      <div className="p-3 bg-white rounded-lg shadow-md">
  <form onSubmit={handleDateSubmit} className="space-y-4">
  <div className="flex space-x-4">
      <div className="flex flex-col flex-grow">
        <label className="text-gray-700 font-semibold">Start Date:</label>
        <input
          type="date"
          className="border border-gray-300 rounded p-2 focus:outline-none focus:border-blue-500"
          value={startDate}
          onChange={(e) => setStartDate(e.target.value)}
          required
        />
      </div>

      <div className="flex flex-col flex-grow">
        <label className="text-gray-700 font-semibold">End Date:</label>
        <input
          type="date"
          className="border border-gray-300 rounded p-2 focus:outline-none focus:border-blue-500"
          value={endDate}
          onChange={(e) => setEndDate(e.target.value)}
          required
        />
      </div>
    </div>

    <div className="flex justify-center">
      <button
        type="submit"
        className="w-full border border-gray-300 text-gray-800 py-2 px-4 rounded hover:bg-gray-100 transition"
        >
        Search by Date
      </button>
    </div>
  </form>

  {isLoadingFilters && <p className="mt-4 text-blue-500">Loading filters...</p>}

  {filtersEnabled && (
    <form onSubmit={handleFinalSubmit} className="mt-6 space-y-3">
      <div className="flex items-center space-x-4">
        <input
          type="checkbox"
          className="mr-2"
          checked={showOrigin}
          onChange={(e) => setShowOrigin(e.target.checked)}
        />
        <label className="text-gray-700 w-40">Filter by Origin</label>
        {showOrigin && (
          <select
            value={origin}
            onChange={(e) => setOrigin(e.target.value)}
            className="border border-gray-300 rounded p-2 flex-grow"
          >
            <option value="">Select Origin</option>
            {uniqueOrigins.map((originOption, index) => (
              <option key={index} value={originOption}>
                {originOption}
              </option>
            ))}
          </select>
        )}
      </div>

      <div className="flex items-center space-x-4">
        <input
          type="checkbox"
          className="mr-2"
          checked={showDestination}
          onChange={(e) => setShowDestination(e.target.checked)}
        />
        <label className="text-gray-700 w-40">Filter by Destination</label>
        {showDestination && (
          <select
            value={destination}
            onChange={(e) => setDestination(e.target.value)}
            className="border border-gray-300 rounded p-2 flex-grow"
          >
            <option value="">Select Destination</option>
            {uniqueDestinations.map((destinationOption, index) => (
              <option key={index} value={destinationOption}>
                {destinationOption}
              </option>
            ))}
          </select>
        )}
      </div>

      <div className="flex items-center space-x-4">
        <input
          type="checkbox"
          className="mr-2"
          checked={showMaxPrice}
          onChange={(e) => setShowMaxPrice(e.target.checked)}
        />
        <label className="text-gray-700 w-40">Filter by Max Price</label>
        {showMaxPrice && (
          <input
            type="number"
            value={maxPrice}
            onChange={(e) => setMaxPrice(e.target.value)}
            placeholder="Enter max price"
            className="border border-gray-300 rounded p-2 flex-grow"
          />
        )}
      </div>

      <div className="flex items-center space-x-4">
        <input
          type="checkbox"
          className="mr-2"
          checked={showMaxPax}
          onChange={(e) => setShowMaxPax(e.target.checked)}
        />
        <label className="text-gray-700 w-40">Filter by Qty of passengers</label>
        {showMaxPax && (
          <input
            type="number"
            value={maxPax}
            onChange={(e) => setMaxPax(e.target.value)}
            placeholder="Enter qty of passengers"
            className="border border-gray-300 rounded p-2 flex-grow"
          />
        )}
      </div>

      <div className="flex items-center space-x-4">
        <input
          type="checkbox"
          className="mr-2"
          checked={showBaggage}
          onChange={(e) => setShowBaggage(e.target.checked)}
        />
        <label className="text-gray-700 w-40">Filter by Baggage</label>
        {showBaggage && (
          <select
            value={baggage}
            onChange={(e) => setBaggage(e.target.value)}
            className="border border-gray-300 rounded p-2 flex-grow"
          >
            <option value="">Select Baggage</option>
            {uniqueBaggage.map((baggageOption, index) => (
              <option key={index} value={baggageOption}>
                {baggageOption}
              </option>
            ))}
          </select>
        )}
      </div>

      <div className="flex items-center space-x-4">
        <input
          type="checkbox"
          className="mr-2"
          checked={showClase}
          onChange={(e) => setShowClase(e.target.checked)}
        />
        <label className="text-gray-700 w-40">Filter by Class</label>
        {showClase && (
          <select
            value={clase}
            onChange={(e) => setClase(e.target.value)}
            className="border border-gray-300 rounded p-2 flex-grow"
          >
            <option value="">Select Class</option>
            {uniqueClases.map((classOption, index) => (
              <option key={index} value={classOption}>
                {classOption}
              </option>
            ))}
          </select>
        )}
      </div>

      <button
        type="submit"
        className="w-full border border-gray-300 text-gray-800 py-2 px-4 rounded hover:bg-gray-100 transition"
      >
        Apply Filters
      </button>
    </form>
  )}
</div>

  );
};
  export default SearchForm;
