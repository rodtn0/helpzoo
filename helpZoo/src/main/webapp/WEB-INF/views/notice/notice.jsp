<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>도와zoo 공지사항</title>
        <style>
            /* 공지사항 타이틀 */
            .ui-header{
                padding-top: 64px;
                padding-bottom: 48px;
                text-align: left;
            }

            .board .ui-header{
                max-width: 800px;
                margin: 0 auto;
                padding-right: 16px;
                padding-left: 16px;
                width: calc(100% - env(safe-area-inset-left) - env(safe-area-inset-right) - 32px);
            }

            .ui-header .title{
                text-align: center;
                line-height: 52px;
                font-size: 48px;
                font-weight: 700;
                word-break: keep-all;
            }

            h2{
                margin: 0;
                padding: 0;
                border: 0;
                vertical-align: baseline;
                font: inherit;
                box-sizing: border-box;
                display: block;
            }

            /* 공지 / 이벤트 네비게이션 */
            .ui-tabs{
                display: block;
                clear: both;
            }

            .ui-tabs li{
                display: inline-block;
            }
            
            .ui-tabs ul{
                display: block;
                text-align: center;
                margin: 0 auto;
                padding: 0 16px;
                height: 68px;
                overflow-x: auto;
                overflow-y: hidden;
                line-height: 0;
                white-space:  nowrap;
                font-size: 0;
            }

            .board-main .article .info .title{
                margin-right: 118px;
                padding-bottom: 8px;
                line-height: 20px;
                color: #1d2129;
                font-size: 15px;
            }

            .ui-tabs li a{
                display: block;
                height: 100%;
            }
            
            .ui-tabs li.active>a{
                border-bottom: 3px solid #00c4c4;
                color: #00b2b2;
                font-weight: 500;
            }
            
            .ui-tabs a{
                line-height: 48px;
                color: black;
                font-size: 17px;
                font-weight: 400;
            }

            /* 게시판 리스트 */
            .board .board-main{
                margin: 0 auto;
                padding-right: 16px;
                padding-left: 16px;
                width: calc(100% - env(safe-area-inset-left) - env(safe-area-inset-right) - 32px);
                max-width: 800px;
            }

            .board-main .article{
                padding: 20px 0 0;
                display: block;
                border-bottom: 1px solid rgba(0,0,0,.1);
            }

            .board-main .article .notice{
                color: #4462ee;
            }

            .board-main .article .info{
                padding-bottom: 20px;
                line-height: 18px;
                font-size: 13px;
            }

            .board-main .article .category{
                color: #00b2b2;
                display: inline-block;
                padding-bottom: 6px;
                line-height: 16px;
                font-size: 12px;
                font-weight: 500;
            }

            em{
                font-style: normal;
            }

            /* 검색창 */

            body li{
                list-style: none;
                box-sizing: border-box;
            }

            body ul{
                list-style: none;
            }

            body select{
                box-sizing: border-box;
                margin: 0;
                border: 0;
            }

            body input{
                margin: 0;
                padding: 0;
            }

            body button{
                box-sizing: border-box;
                margin: 0;
                padding: 0;
            }

            button{
                border-radius: 0;
                cursor: pointer;
                font-weight: 400;
                background: none;
                vertical-align: baseline;
                font: inherit;
                appearance: button;
                text-rendering: auto;
                text-align: center;
                text-indent: 0;
                text-shadow: none;
                align-items: flex-start;
            }

            select{
                font-weight: 400;
                text-rendering: auto;
                word-spacing: normal;
                text-transform: none;
                text-indent: 0px;
                text-shadow: none;
                display: inline-block;
                align-items: center;
                white-space: pre;
                cursor: default;
                font: 400;
                border-radius: 0px;
            }

            .board{
                color: #44484b;
            }

            

            

            .board div{
                box-sizing: border-box;
            }
            
            .board a{
                box-sizing: border-box;
            }
            
            .board .ui-tabs ul{
                position: relative;
                width: 100%;
                max-width: 800px;
            }

            .board-footer{
                padding: 0 16px 160px;
                text-align: center;
            }

            .board-footer .search .filter-container .filter{
                background-color: white;
                padding: 0 0 0 10px;
                width: 100%;
                text-align: center;
                line-height: 34px;
                color: black;
                font-size: 15px;
                appearance: none;
            }

            .board-footer .search .field .search-form{
                border: 1px solid #dadce0;
                padding-right: 64px;
                padding-left: 10px;
                width: 100%;
                line-height: 36px;
                font-size: 15px;
            }

            .board-footer .search .field .btn-search{
                display: block;
                position: absolute;
                top: 0;
                right: 0;
                border: 1px solid #dadce0;
                background-color: #f5f7fa;
                width: 100%;
                max-width: 64px;
                line-height: 36px;
                color: #34383a;
                font-size: 15px;
            }

            .board input{
                box-sizing: border-box;
            }

            input{
                font-weight: 400;
                text-rendering: auto;
                display: inline-block;
                text-align: start;
            }

            div{
                border: 0;
                vertical-align: baseline;
                font: inherit;
                display: block;
                padding: 0;
                margin: 0;
            }

            a{
                margin: 0;
                border: 0;
                padding: 0;
                vertical-align: baseline;
                font:inherit;    
            }
            
            a, a:visited{
                text-decoration: none;
            }
            
            ol, ul{
                list-style: none;
            }
            
            ul{
                margin-block-start: 1em;
                margin-block-end: 1em;
                margin-inline-start: 0px;
                margin-inline-end: 0px;
                padding-inline-start: 40px;
            }

        </style>
    </head>

    <body>
        <main class="board wzui">

            <!-- 공지사항 타이틀 -->
            <div class="ui-header">
                <h2 class="title">공지사항</h2>
            </div>

            <!-- 공지 / 이벤트 네비게이션 -->
            <div class="ui-tabs">
                <ul>
                    <li class="active">
                        <a href="#">공지</a>
                    </li>
                    <li>
                        <a href="#">이벤트</a>
                    </li>
                </ul>
            </div>

            <!-- 게시판 리스트 -->
            <div class="board-main">
                <ul>
                    <li>
                        <a class="article" href="#">
                            <em class="category">공지</em>
                            <div class="info">
                                <h3 class="title">공지사항1</h3>
                                <span class="author">admin</span>
                                <span class="created-at">2020.08.28</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a class="article" href="#">
                            <em class="category">공지</em>
                            <div class="info">
                                <h3 class="title">공지사항2</h3>
                                <span class="author">admin</span>
                                <span class="created-at">2020.08.28</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a class="article" href="#">
                            <em class="category">공지</em>
                            <div class="info">
                                <h3 class="title">공지사항3</h3>
                                <span class="author">admin</span>
                                <span class="created-at">2020.08.28</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a class="article" href="#">
                            <em class="category">공지</em>
                            <div class="info">
                                <h3 class="title">공지사항4</h3>
                                <span class="author">admin</span>
                                <span class="created-at">2020.08.28</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a class="article" href="#">
                            <em class="category">공지</em>
                            <div class="info">
                                <h3 class="title">공지사항5</h3>
                                <span class="author">admin</span>
                                <span class="created-at">2020.08.28</span>
                            </div>
                        </a>
                    </li>
                </ul>
            </div>

            <div class="board-footer">
                <!-- 검색창 -->
                <div class="search">
                    <form method="post" id="news-board-search">
                        <div class="filter-container">
                            <select id="searchSelectInBoard" class="filter" name="">
                                <option value="tc">제목+내용</option>
                                <option value="t">제목</option>
                                <option value="c">내용</option>
                            </select>
                        </div>
                        <div class="field">
                            <label class="text-hidden" for="">검색창</label>
                            <input id="searchTextInBoard" name="searchTextInBoard" class="search-form" type="text" value="">
                            <button class="btn-search dense" type="submit">검색</button>
                        </div>
                    </form>
                    <form id="formSearch" name="formSearchBoard" action="#" method="post">
                        <input id="searchText1" name="searchText1" type="hidden" value="">
                        <input id="searchSelect1" name="searchSelect1" type="hidden" value="">
                        <input id="searchSelect2" name="searchSelect2" type="hidden" value="">
                        <input id="searchSelect4" name="searchSelect4" type="hidden" value="">
                        <input id="searchSelect5" name="searchSelect5" type="hidden" value="">
                    </form>
                </div>
            </div>

        </main>
    </body>
</html>