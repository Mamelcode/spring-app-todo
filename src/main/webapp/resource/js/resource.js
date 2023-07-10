/**
 * 
 */

 document.getElementsById('modifyClick').onclick = (evt) => {
	 var id = $("#modifyClick").data('id');
	 
	 const xhr = new XMLHttpRequest();
	 xhr.open("get", "/todos/gettodo?id="+id, false);
	 xhr.send();
	 
	 const response = JSON.parse(xhr.responseText);
	 
	 if(xhr.status === 200) {
		document.getElementById('modifyDescription').value = response.description
		document.getElementById('modifyStartDate').value = response.startDate
		document.getElementById('modifyEndDate').value = response.endDate
	 };
 };
 
 $('#modifyClick').onclick((evt) => {
	 var id = $("#modifyClick").data('id');
	 
	 const xhr = new XMLHttpRequest();
	 xhr.open("get", "/todos/gettodo?id="+id, false);
	 xhr.send();
	 
	 const response = JSON.parse(xhr.responseText);
	 
	 if(xhr.status === 200) {
		document.getElementById('modifyDescription').value = response.description
		document.getElementById('modifyStartDate').value = response.startDate
		document.getElementById('modifyEndDate').value = response.endDate
	 };
 });
 
 function onclickHandle(evt) {
	 const id = evt.target.value;
	 
	 const xhr = new XMLHttpRequest();
	 xhr.open("get", "/todos/gettodo?id="+id, false);
	 xhr.send();
	 
	 const response = JSON.parse(xhr.responseText);
	 
	 if(xhr.status === 200) {
		document.getElementById('modifyDescription').value = response.description
		document.getElementById('modifyStartDate').value = response.startDate
		document.getElementById('modifyEndDate').value = response.endDate
	 };
 }