<jsp:include page='/MasterPageTopSection.jsp' />
<jsp:useBean id='messageBean' scope='request' class='com.thinking.machines.school.beans.MessageBean' />
<jsp:include page='/StudentsJS.jsp' />

<jsp:getProperty name='messageBean' property='message' />
<div>
<button onclick='switchToForm(1)' >Add</button>
</div>
<div id='viewContainerDivision' class='studentViewContainer showElement'> 
<table border='1' id='studentViewGridTable' class='studentViewGrid'>
<thead width='80px'>
<tr >
<td>Name</td>
<td>Roll Number</td>
<td>City</td>
<td>Gender</td>
<td>Edit</td>
<td>Delete</td>
<td>Details</td>
</tr>
</thead>
<tbody id='studentViewGridBody' >
</tbody>
</table>
</div>
<div id='addFormDivision' class='hideElement'>
<form action='/styletwo/addStudent.jsp' id='addStudentForm' method='post'>
<table border='1'>
<tr>
<td>Roll Number </td><td>
<input type='text' id='roll_number' name='roll_number'>
</td>
</tr>

 <tr>
<td>Name</td>
<td><input type='text' id='name' name='name'></td>
</tr>

<tr>
<td>Address</td>
<td><input type='text' id='address' name='address'></td>
</tr>

<tr>
<td>City</td>
<td><select id='city_code' name='city_code'>
<option value='5'>Agar</option>
<option value='6'>Agra</option>
<option value='4'>Bombay</option>
<option value='7'>Delhi</option>
<option value='2'>Dewas</option>
<option value='3'>Indore</option>
<option value='1'>Ujjain</option>
</select></td>
</tr>

<tr>
<td>Gender</td>
<td><input type='radio' value='F' name='gender' id='gender'>Female
&nbsp;&nbsp;
<input type='radio' value='M' name='gender' id='gender'>Male
</td></tr>


<tr>
<td>Indian</td>
<td><input type='checkbox' id='indian' name='indian' value='true'> </td>
</tr>

<tr>
<td>Date Of Birth</td>
<td><input type='text' id='date_of_birth' name='date_of_birth'> </td>
</tr>

<tr>
<td><button type='button' onclick='switchToView(1)'>Back</button></td>
<td><button type='submit'>Add</button></td>
</tr>
</table>
</form>
</div>

<div id='deleteFormDivision' class='hideElement'>
<form action='/styletwo/deleteStudent.jsp' method='post' id='deleteStudentID'>
<input type='hidden' id='roll_number' name='roll_number'>
<button type='submit'>Submit</button>
</form>
</div>
<div id='detailsViewDivision' class='hideElement studentViewContainer'>
<table border='1' id='detailsViewContainer' class='studentViewGrid'>
<tr>
<td>RollNumber</td>
<td></td>
</tr>
<tr>
<td>Name</td>
<td><input type='text' id='detailsName'> </td>
</tr>
<tr>
<td>Gender</td>
<td><span id='detailsGender'></td>
</tr>
<td><button onclick='switchToView(2)'>Back</button></td>
</tr>
</table>
</div>


<jsp:include page='/MasterPageBottomSection.jsp' />
