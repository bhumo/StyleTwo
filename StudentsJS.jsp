<%@taglib uri='/WEB-INF/tlds/mytags.tld' prefix='tm'%>
<script>
function City()
{
this.code=0;
this.name=' ';
}
function Student()
{
this.rollNumber=0;
this.name='';
this.addresss='';
this.gender='';
this.city=null;
this.dateOFBirth='';
this.indian=false;

}



function ViewModel()
{
this.students=[];
this.selectedRowIndex=-1;
this.selectedRow=null;
}
var viewModel = new ViewModel();
var rollNumberScenario=-1;

<!--<tm:Equals name='scenario' value='added' >
rollNumberScenario=${studentBean.roll_number};
</tm:Equals>-->


var s;
var c;
<tm:TableIterator table='studentView' name='studentBean' orderBy='name'>
s = new Student();
s.name='${studentBean.name}';
s.rollNumber=${studentBean.roll_number};
s.address='${studentBean.address}';
c=new City()
c.code=${studentBean.city_code};
c.name='${studentBean.city_name}';
s.city=c;
s.gender='${studentBean.gender}';
s.indian=${studentBean.indian};
s.dateOfBirth='${studentBean.date_of_birth}';
viewModel.students[${index}]=s;
</tm:TableIterator>

function initializeView()
{
linearSort();
var tableBody=document.getElementById('studentViewGridBody')
var index=0;
var row,cell,img;
var textnode;
for(index=0;index<viewModel.students.length;index++)
{
row = document.createElement('tr');
cell=document.createElement('td');
textNode=document.createTextNode(viewModel.students[index].name.trim());
cell.appendChild(textNode);
cell.textAlign='left';
row.append(cell);

cell =document.createElement('td');
textNode=document.createTextNode(viewModel.students[index].rollNumber);
cell.appendChild(textNode)
cell.textAlign='left';
row.append(cell);

cell =document.createElement('td');
textNode=document.createTextNode(viewModel.students[index].city.name.trim());
cell.appendChild(textNode);
cell.textAlign='left';
row.append(cell);

cell =document.createElement('td');
img=document.createElement('img');
if(viewModel.students[index].gender.trim()=='M')
{
img.src='/styletwo/images/male.png';
}
else
{
img.src='/styletwo/images/female.png';
}
cell.appendChild(img);
row.append(cell);

cell=document.createElement('td');
img=document.createElement('img');
img.src='/styletwo/images/edit.png';
img.onclick = '';
cell.appendChild(img);
row.append(cell);


cell=document.createElement('td');
img=document.createElement('img');
img.src='/styletwo/images/delete.png';
img.onclick = createStudentDeleteHandler(row,index);
cell.appendChild(img);
row.append(cell);
cell.appendChild(img);
row.append(cell);

cell = document.createElement('td');
img = document.createElement('img');
img.src = '/styletwo/images/details.png';
img.onclick = createStudentViewDetailsHandler(index);
cell.appendChild(img);
row.append(cell);
row.className='unselectedRow';
row.style.cursor='pointer';
row.onclick=createSelectStudentRowHandler(row,index); <!-- we are placing a call to the function createSelectStudentRowHandler and passing the current value of i and address of row to it -->
tableBody.appendChild(row);
}<!-- for ends-->
if(rollNumberScenario >0)
{
searchStudentByRollNumber(rollNumberScenario);
}
}<!-- initializeView() ends-->
window.addEventListener('load',initializeView);

function searchStudentByRollNumber(rl)
{
var i=0;
var found=false;
for(i=0;i<viewModel.students.length;i++)
{
if(rl==viewModel.students[i].rollNumber)
{
found=true;
break;
}
}
if(found)
{
var viewContainer=document.getElementById('studentViewGridBody');
var selectedRowAddress=viewContainer.rows.item(i);
selectedRowAddress.scrollIntoView();
selectRow(selectedRowAddress,i);
}
else
{
alert('student with rollNumber' +rl+'not found');
}

}
function studentViewDetails(i)
{
var viewContainer=document.getElementById('viewContainerDivision');
var detailsContainer = document.getElementById('detailsViewDivision');
detailsContainer.className='showElement';
viewContainer.className='hideElement';
var name =document.getElementById('detailsName');
name.value=viewModel.students[i].name;

}
function createStudentViewDetailsHandler(i)
{
return function()
{
studentViewDetails(i);
}
}
function createSelectStudentRowHandler(row,i)
{
return function(){
selectRow(row,i)
} <!-- this is an anonymous function which will store the current value of the loop i and call the selectrow function with i as argument -->
}
function createStudentDeleteHandler(row,index)
{
return function(){
deleteStudent(row,index);
}
}

function deleteStudent(row,index)
{
var viewContainer = document.getElementById('viewContainerDivision');
var div= document.getElementById('deleteFormDivision');
viewContainer.className='hideElement';
div.className='showElement';
alert(div);
var form = document.getElementById('deleteStudentID');
alert('delete form');
form.roll_number.value=viewModel.students[index].rollNumber;
	
}


function selectRow(r,i)
{
if(r==viewModel.selectedRow)return;
if(viewModel.selectedRow!=null)
{
viewModel.selectedRow.className='unselectedRow';
}
viewModel.selectedRow=r;
viewModel.selectedIndex=i;
r.className='selectedRow';
}
var oend=viewModel.students.length-2;
var fend =viewModel.students.length-1;
function linearSort()
{
var e;
var f;
var m=null;
for(e=0;e<oend;e++)
{

for(f=e+1;f<fend;f++)
{

if(viewModel.students[e].name.toUpperCase().localeCompare(viewModel.students[f].name.toUpperCase())>0)
{
m=viewModel.students[e];
viewModel.students[e]=viewModel.students[f];
viewModel.students[f]=m;
}
}
}
}<!--linearSort() ends-->




function searchStudent(t)
{

t.style.color='black'
if(t.value.length == 0) return;
var i;
for(i=0;i<viewModel.students.length;i++)
{
if(viewModel.students[i].name.toUpperCase().startsWith(t.value.toUpperCase()))break;
}
if(i==viewModel.students.length)
{
t.style.color='red';
}
var divGrid = document.getElementById('viewContainerDivision');
var viewContainer=document.getElementById('StudentViewGrid');
var selectedRowAddress=viewContainer.rows.item(i);
selectedRowAddress.scrollIntoView();
selectRow(selectedRowAddress,i);

}

function switchToView(k)
{
if(k==1)
{
var division=document.getElementById("viewContainerDivision");
var addFormDiv = document.getElementById("addFormDivision");
addFormDiv.className='hideElement';
division.className='showElement';
alert("switch to view from delete");
}

if(k==2)
{
var division=document.getElementById("viewContainerDivision");
var detailsViewDiv = document.getElementById("detailsViewDivision");
detailsViewDiv.className='hideElement';
division.className='showElement';
alert('swicthToView');
}

}

function switchToForm(k)
{
if(k==1)
{
var division=document.getElementById("viewContainerDivision");
division.className='hideElement';
var addFormDiv = document.getElementById("addFormDivision");
addFormDiv.className='showElement';
alert('switchToForm');
}

}

</script>