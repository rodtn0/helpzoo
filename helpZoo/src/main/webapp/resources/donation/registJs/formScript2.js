$( "#location" ).selectmenu();
$( "#category" ).selectmenu();

var availableTags = [
    "아름다운 재단",
    "유니세프",
    "사랑의 전화 복지재단",
    "한국 국제기아대책기구",
    "생명의 숲 국민운동",
    "월드비전",
    "굿네이버스",
    "한국여성민우회",
    "굿뜨굿뜨",
    "굿굿굿",
    "굿뜨르르르",
  ];
  $( "#organization" ).autocomplete({
    source: availableTags,
    change: function( event, ui ) {
        updateProgress();
    }
  });


  $( "#donationTitle" ).autocomplete({
    change: function( event, ui ) {
        updateProgress();
    }
  });





$("#experience").spinner({
    min: 0,
    max: 10,
    step: 1,
    change: function( event, ui ) {
        updateProgress();        
    }
});


// $( "#startDate" ).datepicker({
//     minDate: // 오늘 날짜 출력하기
//     new Date(),
//     maxDate:"+2w",
//     dateFormat: "yy-mm-dd",
    
//   });



// $("#startDate").datepicker({
//     minDate: // 오늘 날짜 출력하기
//     new Date(),
//     maxDate:"+2w",
//     dateFormat: "yy-mm-dd",
//     onSelect: function(selected) {
//     $("#startDate").datepicker("option","minDate", selected)
//     }
// });

$( function() {
    $( document ).tooltip();
  } );

  


$(document).ready(function () {
	$("#startDate").datepicker({
		dateFormat: "yy-mm-dd", // 날짜의 형식
		minDate: 0,
		nextText: ">",
		prevText: "<",
		onSelect: function (date) {
			var endDate = $('#endDate');
			var startDate = $(this).datepicker('getDate');
			var minDate = $(this).datepicker('getDate');

            startDate.setDate(startDate.getDate() + 30);
			endDate.datepicker('option', 'maxDate', startDate);
			endDate.datepicker('option', 'minDate', minDate);
		}
	});
	$('#endDate').datepicker({
		dateFormat: "yy-mm-dd", // 날짜의 형식
		nextText: ">",
		prevText: "<"
	});
});


$( "#startDate" ).datepicker( "setDate", "new Date()" );
$( "#endDate" ).datepicker( "setDate" );



$( "input[type='radio']" ).checkboxradio();

$('#submit').button({
    disabled: true
});

$( "#progress" ).progressbar({
    value: 0
});

$('input').change(function(){
    updateProgress();
});

updateProgress();

function updateProgress(){
    var $progress = 0;
    var $itemCount = 7;
    var $itemCompleted = 0;

    var $location = $('#location option:selected').val();
    var $category = $('#category option:selected').val();
    var $organization = $('#organization').val();
    var $experience = $('#experience').val();
    var $date = $('#endDate').val();  
    var $refferrer = $('input[type="radio"]:checked').val();
    var $donationTitle = $('#donationTitle').val();

    
    if($category) $itemCompleted++;
    if($location) $itemCompleted++;
    if($organization) $itemCompleted++;
    if($donationTitle) $itemCompleted++;
    if($experience) $itemCompleted++;
    if($date) $itemCompleted++;
    if($refferrer) $itemCompleted++;

    $progress = parseInt($itemCompleted/$itemCount * 100);
    $( "#progress" ).progressbar( "option", "value", $progress, "html" );
    $('.pct span').text($progress);
    
    if($progress == 100){
        $('#submit').button({
            disabled: false
        });
    }



    
} // updateprogress



$('.docPlan').keyup(function (e){
    var content = $(this).val();
    $('#counter').html("("+content.length+" / 최대 300자)");    //글자수 실시간 카운팅

    if (content.length > 300){
        alert("최대 300자까지 입력 가능합니다.");
        $(this).val(content.substring(0, 300));
        $('#counter').html("(300 / 최대 300자)");
    }
});






