<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.6.0.slim.js" integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>


</head>
<body>

    <%@ include file="/views/common/header.jsp"%>

    <main>
        <div id="container" class="container-xxl">

            <ul class="nav nav-tabs" id="myTab" role="tablist" style="width: 90%; margin-left: 5%; margin-top: 30px;">
                <li class="nav-item" role="presentation" >
                  <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true">장소</button>
                </li>
                <li class="nav-item" role="presentation">
                  <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false">동행</button>
                </li>
              </ul>

              <div class="tab-content" id="myTabContent">
                <!--장소-->
                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">

                    <form action="/hallo03talk/searchPlace/searchDetail" method="get" id="pform">

                        <br><br>
                        <div class="text" style=" width: 50%;float: left;">
                            <h1 style="margin-left: 60px;"><b>검색</b></h1>
                        </div>
                        <br><br><br>
                        <input type="text" name="placeKeyword" class="placeSearch" value="" style="width: 90%; height: 50px; border-radius: 10px; border: 1px solid gray; margin-left: 5%;" placeholder="  검색어를 입력하세요.">
                        <br><br>

                          <!-- 장소 카테고리들 -->
                          <div style="margin-left: 60px; text-align: center; float: left;">

                            <h6 style="float: left; margin-left: 100px; margin-top: 30px; margin-bottom: 10px;">장소 카테고리 선택</h6>

                            <br>

                            <td><select id="selectBox" class="form-control" name="cate1" style="width: 340px;">
                                    <option value="0">선택</option>
                                    <option value="숙소">숙소</option>
                                    <option value="맛집">맛집</option>
                                    <option value="카페">카페</option>
                            </select></td>

                            </div >

                            <div style="margin-left: 60px; text-align: center; float: left;">

                                <h6 style="float: left; margin-left: 100px; margin-top: 30px; margin-bottom: 10px;">지역 카테고리 선택</h6>
    
                                <br>
    
                                <td><select id="selectBox" class="form-control" name="cate2" style="width: 340px;">
                                     <option value="0">선택</option>
                                        <option value="제주">제주</option>
                                        <option value="서귀포">서귀포</option>
                                </select></td>
    
                                </div >

                                <div style="margin-left: 60px; text-align: center; float: left;">

                                    <h6 style="float: left; margin-left: 90px; margin-top: 30px; margin-bottom: 10px;">읍,면,동 카테고리 선택</h6>
        
                                    <br>
        
                                    <td><select id="selectBox" class="form-control" name="cate3" style="width: 340px;">
                                       		<option value="0">선택</option>
                                            <option value="0">---------제주---------</option>
                                            <option value="시내">시내</option>
                                            <option value="애월">애월</option>
                                            <option value="한림">한림</option>
                                            <option value="한경">한경</option>
                                            <option value="조천">조천</option>
                                            <option value="구좌">구좌</option>
                                            <option value="0">---------서귀포---------</option>
                                            <option value="시내">시내</option>
                                            <option value="남원">남원</option>
                                            <option value="안덕">안덕</option>
                                            <option value="대정">대정</option>
                                            <option value="표선">표선</option>
                                            <option value="성산">성산</option>
                                    </select></td>
        
                                    </div >

                        
                        
                        <script type="text/javascript">
                        


                            //탭 바뀌는것
                            //toggle for form & badge
                            $(".js-switch").click(function() {
                            $(".main-content").toggleClass("as-card");
                            });


                            //code for image preview
                            var reader = new FileReader();
                            reader.onload = function(e) {
                            $("#imager").attr("src", e.target.result);
                            };

                            function readURL(input) {
                            if (input.files && input.files[0]) {
                                $("#imager").css("visibility",'visible');
                                reader.readAsDataURL(input.files[0]);
                            }
                            }

                            $("#image-input").change(function() {
                            readURL(this);
                            });

  
                            $("select[id=selectBox]").change(function(){
                            console.log($(this).val()); //value값 가져오기
                            console.log($("select[id=selectBox] option:selected").text()); //text값 가져오기
                            });

                            $(document).ready(function(){
                                $("#send").click(function(){
                                    
                                    if($(".placeSearch").val() == ''){
                                        alert("검색어를 입력해주세요");
                                        return;
                                    }
                                    $("#pform").attr("action", "/hallo03talk/searchPlace/searchDetail"); // attribute setting
                                    $("#pform").submit();
                                });
                            });

                        </script>
                        
		                    <input type="hidden" value="place" name="type">
							<input type="hidden" value="${vo.no}" name="boardNo">


                    </form>

                    <button id="send" type="submit" onclick="getPlaceCate" value="검색" class="btn btn-warning" style="float:right; margin-right: 60px; margin-top: 50px;">검색</button>


                </div>

                <!--동행-->
                <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                    
                   <form action="/hallo03talk/searchWidth/searchWidthDetail" method="get" id="wform">

                    <br><br>
                    <div class="text" style=" width: 50%;float: left;">
                        <h1 style="margin-left: 60px;"><b>검색</b></h1>
                    </div>
                    <br><br><br>
                    <input type="text" name="widthKeyword" class="withSearch" value="" style="width: 90%; height: 50px; border-radius: 10px; border: 1px solid gray; margin-left: 5%;" placeholder="  검색어를 입력하세요.">
                    <br><br>

                      <!-- 날짜 선택 -->
                      <div style="margin-top: 30px; margin-left: 60px; margin-bottom: 0px;">
                        <h4><b>동행 날짜 선택</b></h4>
                        </div>
                        <div id="setday" class="fw-bolder text-center mt-5" style="float: left; margin-left: 30px; margin-top: 0px;">
                        <div style="float: left; ">
          
                            <div id="going" style=" float:left; margin-left: 30px; font-size: 25;">
                            가는날   
                            </div>
                            <input type="date" name="startDate" id="stratDate" style="color: gray; margin-left: 10px; float:left;">
                            <div style=" float:left; margin-left: 50px; font-size: 25;">
                            ~
                            </div>
                            <div id="comming" style=" float:left; margin-left: 50px; font-size: 25;">
                                오는날   
                            </div>
                                <input type="date" name="endDate" id="endDate" style="color: gray; margin-left: 10px; float:left;">
                            </div>
                            <br><br>
                        </div>

                        <br><br>

                        <div id="place-finder" class="fw-bolder text-center mt-5">
     
                            <div style="margin-left: 60px; text-align: center; float: left;">

                                <h6 style="float: left; margin-left: 190px; margin-top: 30px; margin-bottom: 10px;">지역 카테고리 선택</h6>

                                <br>

                                <td><select id="selectBox" class="form-control" name="cate4" style="width: 540px;">
                                      	<option value="0">선택</option> 
                                        <option value="제주">제주</option>
                                        <option value="서귀포">서귀포</option>
                                </select></td>

                                </div >

                                <div style="margin-left: 60px; text-align: center; float: left;">

                                    <h6 style="float: left; margin-left: 190px; margin-top: 30px; margin-bottom: 10px;">읍,면,동 카테고리 선택</h6>
        
                                    <br>
        
                                    <td><select id="selectBox" class="form-control" name="cate5" style="width: 540px;">
                                            <option value="0">선택</option>
                                            <option value="0">---------제주---------</option>
                                            <option value="시내">시내</option>
                                            <option value="애월">애월</option>
                                            <option value="한림">한림</option>
                                            <option value="한경">한경</option>
                                            <option value="조천">조천</option>
                                            <option value="구좌">구좌</option>
                                            <option value="0">---------서귀포---------</option>
                                            <option value="시내">시내</option>
                                            <option value="남원">남원</option>
                                            <option value="안덕">안덕</option>
                                            <option value="대정">대정</option>
                                            <option value="표선">표선</option>
                                            <option value="성산">성산</option>
                                    </select></td>
        
                                    </div >



                        <script>
                            //탭 바뀌는것
                            //toggle for form & badge
                            $(".js-switch").click(function() {
                            $(".main-content").toggleClass("as-card");
                            });


                            //code for image preview
                            var reader = new FileReader();
                            reader.onload = function(e) {
                            $("#imager").attr("src", e.target.result);
                            };

                            function readURL(input) {
                            if (input.files && input.files[0]) {
                                $("#imager").css("visibility",'visible');
                                reader.readAsDataURL(input.files[0]);
                            }
                            }

                            $("#image-input").change(function() {
                            readURL(this);
                            });

                            
                            $("select[id=selectBox]").change(function(){
                            console.log($(this).val()); //value값 가져오기
                            console.log($("select[id=selectBox] option:selected").text()); //text값 가져오기
                            });
                            
//                       $(document).ready(function(){
/*                                $("#wsend").click(function(){
                                    
                                    if($(".withSearch").val() == ''){
                                        alert("검색어를 입력해주세요");
                                        return;
                                    }
                                    $("#wform").attr("action", "/hallo03talk/searchWidth/searchWidthDetail"); // attribute setting
                                    $("#wform").submit();
                                });
                            });*/

                    </script>


                    </div>

                   <button type="submit" id="wsend"  value="검색" class="btn btn-warning" style="float:right; margin-right: 60px; margin-top: 50px;">검색</button>
                   </form> 


                </div>

              </div>
    
          <br>

    
        </body>

            </div>
    </main>


<footer></footer>

</body>
</html>