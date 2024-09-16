import React, { useRef, useEffect} from 'react';
 export const FormComponent: React.FC = () => {
    const inputRef = useRef<HTMLInputElement>(null);
  
    useEffect(() => {
      // Focus on the input field when the component mounts
      if (inputRef.current) {
        inputRef.current.focus();
      }
    }, []);
  
    return (
      <form className="form-container">
        <label className="form-label">
          Name:
          <input className="form-input" type="text" ref={inputRef} />
        </label>
        <button className="form-submit-button" type="submit">
          Submit
        </button>
      </form>
    );
  };