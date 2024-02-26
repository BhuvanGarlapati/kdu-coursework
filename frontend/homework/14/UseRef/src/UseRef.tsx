
import { ScrollToTop } from './ScrollToTop';
import { FormComponent } from './FormComponent';
import { Timer } from './Timer';
import './App.scss'; 

  const UseRef = () => {
    return (
      <div className="app-container">
        <h1 className="app-title">React useRef Examples</h1>

        <hr className="app-divider" />
        <FormComponent />
        <hr className="app-divider" />
        <Timer />
        <ScrollToTop />
      </div>
    );
  };
  
  export default UseRef;