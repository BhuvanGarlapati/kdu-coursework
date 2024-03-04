
// JavaScript code
let likeCount = 0;
let isLiked = false;

function like() {
    // Toggle the like state
    isLiked = !isLiked;

    // Get the button and count elements
    const likeButton = document.getElementById('likeButton');
    const likeCountElement = document.getElementById('likeCount');

    // Update the button color based on the like state
    if (isLiked) {
        likeButton.classList.add('liked');
    } else {
        likeButton.classList.remove('liked');
    }

    // Increase or decrease the like count
    likeCount = isLiked ? likeCount + 1 : Math.max(likeCount - 1, 0);

    // Update the like count element
    likeCountElement.textContent = likeCount;
}
 function handleImageUpload(event) {
   const fileInput = event.target;
   const imagePreview = document.getElementById('imagePreview');

   // Check if a file is selected
   if (fileInput.files && fileInput.files[0]) {
     const reader = new FileReader();

     // Read the selected file as Data URL
     reader.readAsDataURL(fileInput.files[0]);

     // Set the image source and display it
     reader.onload = function (e) {
       const imageUrl = e.target.result;
       imagePreview.innerHTML = `<img src="${imageUrl}" alt="Uploaded Image">`;
     };
   }
 }

 function showHide(divID){
    if (document.getElementsByClassName(divID).style.display == "none") {
    document.getElementsByClassName(divID).style.display = "block";
    
    } else {
    document.getElementsByClassName(divID).style.display = "none";
    
    }
    }