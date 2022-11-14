function reviewFormBtn () {
  if (document.querySelector("#reviewForm").classList.contains("showForm")) {
    document.querySelector("#reviewForm").classList.replace("showForm", "hideForm");
  } else {
    document.querySelector("#reviewForm").classList.replace("hideForm", "showForm");
  }
};

function cancelReview() {
  document.querySelector("#reviewForm").classList.replace("showForm", "hideForm");
};
