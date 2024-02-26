import  { useRef, useState} from 'react';
export const Timer = () => {
    const timerRef = useRef<number | null>(null);
    const [seconds, setSeconds] = useState(0);
  
    const startTimer = () => {
      timerRef.current = window.setInterval(() => {
        setSeconds((prevSeconds) => prevSeconds + 1);
      }, 1000);
    };
  
    const stopTimer = () => {
      if (timerRef.current !== null) {
        clearInterval(timerRef.current);
      }
    };
  
    const resetTimer = () => {
      stopTimer();
      setSeconds(0);
    };
    return (
        <div className="timer-container">
          <p className="timer-label">Timer: {seconds} seconds</p>
          <button className="timer-button" onClick={startTimer}>
            Start Timer
          </button>
          <button className="timer-button" onClick={stopTimer}>
            Stop Timer
          </button>
          <button className="timer-button" onClick={resetTimer}>
            Reset Timer
          </button>
        </div>
      );
    };