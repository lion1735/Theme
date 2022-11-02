// const HOST = "http://localhost:8080"
const HOST = "http://k7c203.p.ssafy.io:8000"
const USER = "/user"
const THEME = '/theme'
const BOARD = '/board'
const FOLLOW = '/follow'
const FEED = '/feed'
const COMMENT = '/comment'
const MAP = '/map'
const SEARCH = '/search'


// 카카오
const KAKAO_Host = "https://kauth.kakao.com"
const REDIRECT_URI = "http://localhost:8080"
// const REDIRECT_URI = "http://k7c2031.p.ssafy.io:8080"
const KAKAO_GET_AUTHORIZATION = `/oauth/authorize?client_id=${process.env.VUE_APP_KAKAO_REST_API_KEY}&redirect_uri=${REDIRECT_URI}&response_type=code`
const KAKAO_TOKEN = "/oauth/token"
export default {
    kakao: {
        redirect:()=> REDIRECT_URI,
        getAuth: () => KAKAO_Host + KAKAO_GET_AUTHORIZATION,
        login: () => KAKAO_Host + KAKAO_TOKEN
    },

    User: {
        login:() => HOST + USER + '/login',
        userInfo: (_user_id: string) => HOST + USER + `/info/${_user_id}`,
        userInfo2: (_user_idx:string) => HOST + USER + `info/id/${_user_idx}`,
        userTheme:(_user_id:string) => HOST + USER + THEME + `/${_user_id}`,
        userBoard:(_theme_id:string,_user_id:string) => HOST + USER + BOARD + `/${_theme_id}/${_user_id}`,
        signOut:(_user_id:string) => HOST + USER + `/${_user_id}`,
        themeFollow:(_theme_id:string, _user_id:string, _target_user_id:string) => HOST + USER + FOLLOW + `/${_theme_id}/${_user_id}/${_target_user_id}`,
        cancelThemeFollow:(_follow_id:string) => HOST + USER + FOLLOW + `/${_follow_id}`,
        themeFollowList:(_user_id:string) => HOST + USER + `/following/${_user_id}`,
        followerList: (_user_id: string) => HOST + USER + `/follower/${_user_id}`,
        followingThemeIdxList: (_user_id:string) => HOST + USER + '/following' + THEME + `/${_user_id}`,
        followingList:(_user_id:string) => HOST + USER + `/following/${_user_id}`,
        unfollow: (_target_user_idx:string,_user_idx:string) => HOST + USER + `/unfollow/${_target_user_idx}/${_user_idx}`,
        duplication: (_nickname:string) => HOST + USER + `/duplication/${_nickname}`,
    },

    Board: {
        createArticle:() => HOST + FEED + BOARD,
        fetchArticle:(_board_id:string) => HOST + FEED + BOARD + `/${_board_id}`,
        LikeArticle:(_board_id:string) => HOST + FEED + BOARD + `/like/${_board_id}`,
        reportArticle:(_board_id:string,_reporter_id:string) => HOST + BOARD + `/alert/${_board_id}/${_reporter_id}`,
        detailArticle:(_board_id:string) => HOST + BOARD + `/${_board_id}`
    },

    Comment: {
        commentInfo:(_board_id:string) => HOST + FEED + COMMENT +`/${_board_id}`,
        reportComment:(_board_id:string,_reporter_id:string) => HOST + FEED + COMMENT + `/alert/${_board_id}/${_reporter_id}`
    },

    Feed: {
        recommendTheme:() => HOST + FEED + '/recommend', 
        feedList:()=> HOST + FEED  //params로 region 넘겨야함(0:전국 1:서울 2:대전 3:광주 4:구미 5:부울경)
    },

    Map: {
        publicThemeList:() => HOST + THEME + MAP + THEME,   //params로 isMarked, sort 넘겨야함(0은 인기순, 1은 최신순)
        themeArticleList:(_theme_id:string) => HOST + THEME + MAP + `/${_theme_id}`, // params로 sort 넘겨야함(0은 인기순 1은 최신순)
        placeArticleList:() => HOST + THEME + MAP + '/place'    // params로 value (주소)
    },

    Search: {
        recommendUser:()=> HOST + THEME + SEARCH,
        userAutoComplete:()=>HOST + THEME + SEARCH + USER,  // params로 value = input값
        themeAutoComplete:()=>HOST + THEME + SEARCH + THEME,    //params로 value = input값
        userSearch:() => HOST + THEME + SEARCH + USER + '/info',    //params로 value= input값
        themeSearch:() => HOST + THEME + SEARCH + THEME + '/info'   //params로 value = input값
    },
    Theme: {
        createTheme:()=> HOST + THEME,
        recommendTheme:()=> HOST + THEME + '/recommand',
        isTheme:()=>HOST + THEME + SEARCH,
    }
}