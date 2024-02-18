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
           
        });

        const postsDiv = document.getElementsByClassName("posts")[0];
        fetch(`http://${window.location.hostname}:3000/api/posts/5/1`)
          .then((response) => response.json())
          .then((posts) => {
            posts.forEach((post) => {
              const postElement = createPostElement(post);
              postsDiv.appendChild(postElement);
            });
          })
          .catch((error) => {
            console.error("Error in the fetching posts:", error);
          });
          window.addEventListener("scroll", function () {
            if (
              window.innerHeight + window.scrollY >=
              document.body.offsetHeight *.95
            ) {
              fetchMorePosts();
            }
          });
          if (window.innerWidth < 500) {
            const parentElement = document.querySelector(".tweet-box");
            const toReplace = document.querySelector(".tweet-box-profile");
            parentElement.replaceChild(childElement, toReplace);
          }
          let imageInput = document.querySelector("#imageInput");
          let tweetBox = document.querySelector(".tweet-box");
          let postButton = document.querySelector(".tweet-btn");
          let tweetInput = document.querySelector(".post-input");
          
          const posts = document.getElementsByClassName("posts")[0];
          const profileIcon = document.getElementsByClassName("profile-icon")[0];
          imageInput.addEventListener("change", handleImageInput);
          profileIcon.addEventListener("click", showNavigationSection);
          
          tweetInput.addEventListener("input", function () {
            const tweetContent = tweetInput.value.trim();
            if (tweetContent.length > 0) {
              postButton.style.backgroundColor = "#1D9BF0";
              postButton.style.color = "white";
            } else {
              postButton.style.backgroundColor = "";
              postButton.style.color = "";
            }
          });
        
          floatingTweetBoxIcon.addEventListener("click", function () {
            if (tweetBoxProfileMobile.style.display === "none") {
              tweetBoxProfileMobile.style.display = "block";
              posts.style.display = "none";
              tweetBox.style.display = "flex";
        
              tweetInput.style.display = "block";
              profileIcon.style.display = "none";
              floatingTweetBoxIcon.style.display = "none";
            } else {
              tweetBoxProfileMobile.style.display = "none";
            }
          });
             
        
          fetch(`http://${window.location.hostname}:3000/api/posts`, {
            method: "POST",
            headers: {
              "Content-Type": "application/json",
            },
            body: JSON.stringify(newPost),
          })
            .then((response) => {
              if (response.ok) {
                return response.json();
              } else {
                throw new Error("Failed to add post");
              }
            })
            .then((post) => {
              createPostElement(post);
              if (window.innerWidth < 500) {
                posts.style.display = "block";
                profileIcon.style.display = "flex";
                floatingTweetBoxIcon.style.display = "flex";
                tweetBox.style.display = "none";
              }
              window.location.reload();
    
              tweetInput.value = "";
              postButton.style.backgroundColor = "";
              postButton.style.color = "";
            });
                function fetchMorePosts() {
                    const pageSize = 5;
                    fetch(`http://${window.location.hostname}:3000/api/posts/${pageSize}/${page}`)
                    .then((response) => response.json())
                    .then((posts) => {
                        posts.forEach((post) => {
                        const postElement = createPostElement(post);
                        const postsDiv = document.getElementsByClassName("posts")[0];
                        postsDiv.appendChild(postElement);
                        });
                    })
                    .catch((error) => {
                        console.error("Error in the fetching more posts:", error);
                    });
                    page = page + 1;
                }
                