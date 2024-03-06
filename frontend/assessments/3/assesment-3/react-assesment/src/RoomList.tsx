const container:React.CSSProperties={
    display:"flex",
    flexDirection:"column"
}
const titles:React.CSSProperties ={
    fontFamily:"Poppins",
    fontWeight:"bolder",
    fontSize:"2rem",
    marginBottom:"20px"
}
const selectroom:React.CSSProperties={
    paddingLeft:"20px",
    marginTop:"20px",
    fontFamily:"Poppins",
    width:"100%",
    height:"50px",
    backgroundColor:"#fc6f03",
    color:"white",
    display:"flex",
    justifyContent:"flex-start",
    alignContent:"center",
    alignItems:"center"
}
const selectblock:React.CSSProperties={
    fontFamily:"Poppins",
    display:"flex",
    flexDirection:"row",
    justifyContent:"flex-start"
}
const roomss:React.CSSProperties={
    fontFamily:"Poppins",
    marginLeft:"25px",
    marginTop:"20px",
    width:"180px",
    height:"50px",
    display:"flex",
    alignContent:"center",
    alignItems:"center",
    border:"1px solid black",
    textAlign:"center",
    justifyContent:"center"
}
const costs:React.CSSProperties= {
    display:"flex",
    fontSize:"1.6rem",
    fontFamily:"Poppins",
    fontWeight:"normal"
}
const submit:React.CSSProperties ={
    width:"10%",
    height:"40px",
    fontFamily:"poppins",
    border:"1px  solid #fc6f03",
    backgroundColor:"#fc6f03",
    color:"white",display:"flex",
    alignContent:"center",
    alignItems:"center",
    justifyContent:"center"
 
}
import React, { useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { RootState, AppDispatch } from './redux/store'
import { setRooms } from './redux/roomSlice';
import BasicDateTimePicker from './Calender'


const RoomList: React.FC = () => {
    
 const dispatch = useDispatch<AppDispatch>();
 const allRooms = useSelector((state: RootState) => state.rooms.rooms);


 useEffect(() => {
    const fetchRooms = async () => {
      try {
        const response = await fetch('https://kdu-automation.s3.ap-south-1.amazonaws.com/mini-project-apis/assessment-3.json');
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        const data = await response.json();
        // // eslint-disable-next-line @typescript-eslint/no-explicit-any
        // const mappedData: Room[] = data.map((item: any) => ({
        //   id: item.id, 
        //   name: item.name,
        //   costPerNight:item.costPerNight,
        //   currency: item.currency,
        //   addOns:item.name
        // }));
        dispatch(setRooms(data));
      } catch (error) {
        console.error('There was a problem with your fetch operation:', error);
      }
    };

    fetchRooms();
 }, [dispatch]);

let sum='';
function singleRoom(){
    allRooms.filter(room => room.name=== "Single Room").forEach(summation =>{
       sum += summation.costPerNight;
    })
}

function twinRoom(){
    allRooms.filter(room => room.name === "Twin Room").forEach(summation =>{
       sum += summation.costPerNight;
    })
}
console.log("sum:`${sum}`");
function deulexRoom(){
    allRooms.filter(room => room.name === "Deluxe").forEach(summation =>{
       sum += summation.costPerNight;
    })
}


function residential(){
    allRooms.filter(room => room.name === "Presidential Suite").forEach(summation =>{
       sum += summation.costPerNight;
    })
}
console.log(`sum: ${sum}`);
function breakfast(){
    allRooms.filter(room => room.addOns.forEach(roome=>roome.name === "Breakfast")).forEach(summation =>{
        sum += summation.costPerNight;
     })
 }
 function seafacing(){
    allRooms.filter(room => room.addOns.forEach(roome=>roome.name === "Sea Facing")).forEach(summation =>{
        sum += summation.costPerNight;
     })
 }
 function balcony(){
    allRooms.filter(room => room.addOns.forEach(roome=>roome.name === "Balcony Unit")).forEach(summation =>{
        sum += summation.costPerNight;
     })
 }
  
 console.log(`sum: ${sum}`); 
 return (
  <>
  
  <div style={container}>
    <div style={titles}>Hotel Booking</div>
    <div style={selectroom}>Select Room Type</div>
    <div style={selectblock}>
        <div style={roomss} onClick={singleRoom}>
            Single Room
        </div>
        <div style={roomss} onClick={twinRoom}>
            Twin Room
        </div>
        <div style={roomss} onClick={deulexRoom}>
            Dulex
        </div>
        <div style={roomss} onClick={residential}>
        residential Suite
        </div>
    </div>
    <div style={selectroom}>Select Date</div>
    <div style={selectblock}>
        <div >
        <BasicDateTimePicker />
        </div>
       
        </div>

        <div style={selectroom}>Select Date</div>
    <div style={selectblock}>
        <div style={roomss} onClick={breakfast}>
            BreakFast
        </div>
        <div style={roomss} onClick={seafacing}>
            Balcony Unit
        </div>
        <div style={roomss} onClick={balcony}>
            Sea Facing
        </div>
        </div >
        <h4 style={costs}>Cost + 18% GST = 5300</h4>
        <div style={submit}>
            Submit 
        </div>

  </div>

  </>
  
 );
};

export default RoomList;