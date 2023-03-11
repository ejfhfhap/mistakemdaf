$.ajax({
    type:"GET",
    url:"/member/getNaverData",
    success:(response)=>{
        response = JSON.parse(response);
        console.log(response.items);
        for(let item of response.items){
            console.log(item);
        }
    }
})