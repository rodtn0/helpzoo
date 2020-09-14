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
    "한국여성민우회"
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
    disabled: false
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
    var $itemCount = 8;
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



class MyUploadAdapter {
    constructor( loader ) {
        // The file loader instance to use during the upload.
        this.loader = loader;
    }

    // Starts the upload process.
    upload() {
        return this.loader.file
            .then( file => new Promise( ( resolve, reject ) => {
                this._initRequest();
                this._initListeners( resolve, reject, file );
                this._sendRequest( file );
            } ) );
    }

    // Aborts the upload process.
    abort() {
        if ( this.xhr ) {
            this.xhr.abort();
        }
    }

    // Initializes the XMLHttpRequest object using the URL passed to the constructor.
    _initRequest() {
        const xhr = this.xhr = new XMLHttpRequest();

        // Note that your request may look different. It is up to you and your editor
        // integration to choose the right communication channel. This example uses
        // a POST request with JSON as a data structure but your configuration
        // could be different.
        xhr.open( 'POST', 'http://example.com/image/upload/path', true );
        xhr.responseType = 'json';
    }

    // Initializes XMLHttpRequest listeners.
    _initListeners( resolve, reject, file ) {
        const xhr = this.xhr;
        const loader = this.loader;
        const genericErrorText = `Couldn't upload file: ${ file.name }.`;

        xhr.addEventListener( 'error', () => reject( genericErrorText ) );
        xhr.addEventListener( 'abort', () => reject() );
        xhr.addEventListener( 'load', () => {
            const response = xhr.response;

            // This example assumes the XHR server's "response" object will come with
            // an "error" which has its own "message" that can be passed to reject()
            // in the upload promise.
            //
            // Your integration may handle upload errors in a different way so make sure
            // it is done properly. The reject() function must be called when the upload fails.
            if ( !response || response.error ) {
                return reject( response && response.error ? response.error.message : genericErrorText );
            }

            // If the upload is successful, resolve the upload promise with an object containing
            // at least the "default" URL, pointing to the image on the server.
            // This URL will be used to display the image in the content. Learn more in the
            // UploadAdapter#upload documentation.
            resolve( {
                default: response.url
            } );
        } );

        // Upload progress when it is supported. The file loader has the #uploadTotal and #uploaded
        // properties which are used e.g. to display the upload progress bar in the editor
        // user interface.
        if ( xhr.upload ) {
            xhr.upload.addEventListener( 'progress', evt => {
                if ( evt.lengthComputable ) {
                    loader.uploadTotal = evt.total;
                    loader.uploaded = evt.loaded;
                }
            } );
        }
    }

    // Prepares the data and sends the request.
    _sendRequest( file ) {
        // Prepare the form data.
        const data = new FormData();

        data.append( 'upload', file );

        // Important note: This is the right place to implement security mechanisms
        // like authentication and CSRF protection. For instance, you can use
        // XMLHttpRequest.setRequestHeader() to set the request headers containing
        // the CSRF token generated earlier by your application.

        // Send the request.
        this.xhr.send( data );
    }
}

// ...

function MyCustomUploadAdapterPlugin( editor ) {
    editor.plugins.get( 'FileRepository' ).createUploadAdapter = ( loader ) => {
        // Configure the URL to the upload script in your back-end here!
        return new MyUploadAdapter( loader );
    };
}

// ...

ClassicEditor
    .create( document.querySelector( '#editor' ), {
        extraPlugins: [ MyCustomUploadAdapterPlugin ],

        // ...
    } )
    .catch( error => {
        console.log( error );
    } );



// 파일 미리보기
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



// 팝업창
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
