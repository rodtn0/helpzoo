

$( function() {
    $( document ).tooltip();
  } );

  



$( "input[type='radio']" ).checkboxradio();






$('.docPlan').keyup(function (e){
    var content = $(this).val();
    $('#counter').html("("+content.length+" / 최대 300자)");    //글자수 실시간 카운팅

    if (content.length > 300){
        alert("최대 300자까지 입력 가능합니다.");
        $(this).val(content.substring(0, 300));
        $('#counter').html("(300 / 최대 300자)");
    }
});







function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        
        reader.onload = function(e) {
        $('#mainImg').attr('src', e.target.result);
        }
        
        reader.readAsDataURL(input.files[0]); // convert to base64 string
    }
    }

    $("#ex_file").change(function() {
     readURL(this);
});


$(document).ready(function(){
    $(".open").on("click", function(){
      $(".popup").show();
      $(".dim").show();
    });

    $(".popup .close").on("click", function(){
      $(this).parent().hide();
      $(".dim").hide();
    });

  });


  function setDisplay(){
    if($('input:radio[id=aaa]').is(':checked')){
        $('#divId').hide();
        $('#textarea').hide();
    }else{
        $('#divId').show();
        $('#textarea').show();
    }

    
}




$('.docPlan').keyup(function (e){
    var content = $(this).val();
    $('#counter').html("("+content.length+" / 최대 500자)");    //글자수 실시간 카운팅

    if (content.length > 500){
        alert("최대 500자까지 입력 가능합니다.");
        $(this).val(content.substring(0, 500));
        $('#counter').html("(500 / 최대 500자)");
    }
});

$('.docPlan2').keyup(function (e){
    var content = $(this).val();
    $('#counter2').html("("+content.length+" / 최대 500자)");    //글자수 실시간 카운팅

    if (content.length > 500){
        alert("최대 500자까지 입력 가능합니다.");
        $(this).val(content.substring(0, 500));
        $('#counter2').html("(500 / 최대 500자)");
    }
});