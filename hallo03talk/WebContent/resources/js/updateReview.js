function writeBtn() {
  if (document.querySelector("#commentForm").classList.contains("showForm")) {
    document.querySelector("#commentForm").classList.replace("showForm", "hideForm");
  } else {
    document.querySelector("#commentForm").classList.replace("hideForm", "showForm");
  }
};

function cancelBtn() {
  document.querySelector("#commentForm").classList.replace("showForm", "hideForm");
};

function delBtn(replyNo) {
  if (confirm("삭제 하시겠읍니까?")) {
    $.ajax({
      method: "POST",
      url: "/hallo03talk/review/replyDel",
      data: {
        "replyNo" : replyNo
      },
      success: function (response) {
        if(response == 1) {
          alert('삭제');
          history.go(0);
        } else {
          alert('실패');
        }
      },
      error : function () {

      }
    });
  } else {
    
  }
};

