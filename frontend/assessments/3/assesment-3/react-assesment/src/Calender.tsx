import * as React from 'react';
import dayjs, { Dayjs } from 'dayjs';
import { DemoContainer } from '@mui/x-date-pickers/internals/demo';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { DateTimePicker } from '@mui/x-date-pickers/DateTimePicker';
const dates:React.CSSProperties={
    display:"flex",
    flexDirection:"row"
}
const divs:React.CSSProperties={
    width:"20px"
}
export default function DateTimePickerValue() {
  const [value, setValue] = React.useState<Dayjs | null>(dayjs('2024-01-03T1:30'));

  return (
    <LocalizationProvider dateAdapter={AdapterDayjs}>
      <DemoContainer components={['DateTimePicker', 'DateTimePicker']}>
        <div style={dates}>
        <DateTimePicker
          defaultValue={dayjs('2024-01-03T1:30')}
        />
        <div style={divs}>    </div>
        <DateTimePicker
          value={value}
          onChange={(newValue) => setValue(newValue)}
        />

        </div>
        
      </DemoContainer>
    </LocalizationProvider>
  );
}