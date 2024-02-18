const now = new Date();
const hours = now.getHours();
const minutes = now.getMinutes();
        const messageInput = document.getElementById("msgText");
        const sendButton = document.getElementById("sendMessage");
        const topcont=document.querySelector(".container-top");
        const messanger1=document.getElementsByClassName("message-head");
    
        function addMessage(from,message,time1){
            if (message !== '') {
            const messageOutput = document.querySelector(".container-main");
            const totalmessage = document.createElement('div');
            const totalmessage1 = document.createElement('div');
            const messageElement = document.createElement('div');
            const times=document.createElement('div');
            // times.classList.add('times-style');
            totalmessage.classList.add('totalmessage');
            totalmessage1.classList.add('totalmessage1');
            if(from === "You"){            
            messageElement.classList.add("message"); 
            messageElement.textContent = message;
            times.textContent= time1;
            times.innerHTML = `<span>${time1}</span>`;
            times.classList.add('times-style');
          
            totalmessage1.appendChild(messageElement);
            messageOutput.appendChild(totalmessage1);
            messageOutput.appendChild(times);
            } else {             
                messageElement.classList.add("other-message");
                times.innerHTML= `<span>${time1}</span>`;
                times.classList.add('times-style1');
               
                messageElement.textContent = message;
                totalmessage.appendChild(messageElement);
                messageOutput.appendChild(totalmessage); 
                messageOutput.appendChild(times);
                
            }
        messageInput.value = '';
        messageOutput.scrollTop = messageOutput.scrollHeight;
        }
    }

    function addprofile(name){
        const card=document.createElement('div');
        const card1=document.createElement('div');
        const card2=document.createElement('p');
        const card3=document.createElement('p');

        card.classList.add('message-person');
        card1.classList.add('create-icon');
        card2.classList.add('text-person');
        card3.classList.add('tweet-id');

        card1.textContent=name.substring(0,1);
        card.appendChild(card1);

        card2.textContent=name;
        card.appendChild(card2);

        card3.textContent="@"+name+"_";
        card.appendChild(card3);
    
        messanger1[0].append(card);
    }
    
        sendButton.addEventListener("click",()=>{
            const message = messageInput.value;
            //emit the message
            socket.emit("message",message);
            addMessage("You",message,`${hours}:${minutes}pm`);
        });
    var a=1;
        const socket = io("http://localhost:3000");
        socket.on("new-message",(message)=>{
            if(a===1){
                ++a;
                const username=document.createElement('h6');
                username.classList.add('heading');
                username.textContent=message.username;
                topcont.append(username); 
                addprofile(message.username);
              
            }
           
            addMessage(message.username,message.text,message.time);
           
        })