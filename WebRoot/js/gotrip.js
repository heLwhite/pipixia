window.onload=function()
{
	var sunbmit=document.getElementsByClassName("submit")[0];
	var input=document.getElementsByClassName("gtt_input")[0];
	subOpen(
			{
				address:"shop/shopweb",
				message:function(even)
				{
					console.log(even.data);
				}
			}
			);
	var clear=function()
	{
		
		input.value="";
	}
	sunbmit.onclick=function()
	{
		onsubSend(input.value,clear);
	}
	
}