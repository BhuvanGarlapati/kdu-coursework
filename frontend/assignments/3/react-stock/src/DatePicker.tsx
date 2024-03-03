import React, { useState } from 'react';
import dayjs, { Dayjs } from 'dayjs';
import { DemoContainer } from '@mui/x-date-pickers/internals/demo';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { DatePicker } from '@mui/x-date-pickers/DatePicker';
import { useDispatch } from 'react-redux';
import { setStartDate, setEndDate } from './redux/filterSlice'; // Import your action creators
const datesbox:React.CSSProperties={
    display:"flex",
    flexDirection:"row",
    borderBottom:"1px solid #6f7072",
    paddingBottom:"10px",
    color:"#6f7072",
    justifyContent:"space-around"
}
const DatePickerValue: React.FC = () => {
  const dispatch = useDispatch();
  const [startDate, setStartDateLocal] = useState<Dayjs | null>(dayjs('2022-04-17'));
  const [endDate, setEndDateLocal] = useState<Dayjs | null>(dayjs());

  const handleStartDateChange = (date: Dayjs | null) => {
    setStartDateLocal(date);
    dispatch(setStartDate(date?.toDate() || null)); // Dispatch the start date
  };

  const handleEndDateChange = (date: Dayjs | null) => {
    setEndDateLocal(date);
    dispatch(setEndDate(date?.toDate() || null)); // Dispatch the end date
  };

  return (
    <LocalizationProvider dateAdapter={AdapterDayjs}>
      <DemoContainer components={['DatePicker', 'DatePicker']}>
        <div style={datesbox}>
          <div style={{ 'width': '40%', marginLeft: "10px" }}>
            <DatePicker
              value={startDate}
              onChange={handleStartDateChange}
              format="YYYY-MM-DD"
              
            />
          </div>
          <div style={{ 'width': '40%', marginRight: "10px" }}>
            <DatePicker
              value={endDate}
              onChange={handleEndDateChange}
              format="YYYY-MM-DD"
              
            />
          </div>
        </div>
      </DemoContainer>
    </LocalizationProvider>
  );
};

export default DatePickerValue;
