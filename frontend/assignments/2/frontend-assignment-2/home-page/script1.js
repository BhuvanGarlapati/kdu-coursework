const message=document.getElementById("messages");
function openBlankScreen() {
  window.open('chat.html');
}
message.addEventListener('click',()=>{
  openBlankScreen();
})

