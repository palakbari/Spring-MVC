<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
	<body>
	      <div class="main">
	          <h2>Registration Form</h2>
	            <form action="getRegisters">
	                <label for="first"
	                    >First Name:</label>
	                <input
	                    type="text"
	                    id="first"
	                    name="first"
	                    required
	                />
	 				<br>
	 				
	                <label for="last"
	                    >Last Name:</label
	                >
	                <input
	                    type="text"
	                    id="last"
	                    name="last"
	                    required
	                />
	 				<br>
	 				
	                <label for="email">Email:</label>
	                <input
	                    type="email"
	                    id="email"
	                    name="email"
	                    required
	                />
	 				<br>
	 				
	                <label for="password"
	                    >Password:</label
	                >
	                <input
	                    type="password"
	                    id="password"
	                    name="password"
	                    required
	                />
	 				<br>
	 				
	                <label for="mobile"
	                    >Contact:</label
	                >
	                <input
	                    type="text"
	                    id="mobile"
	                    name="mobile"
	                    maxlength="11"
	                    required
	                />
	 				<br>
	 				
	                <label for="gender"
	                    >Gender:</label
	                >
	                <select
	                    id="gender"
	                    name="gender"
	                    required
	                >
	                    <option value="male">
	                        Male
	                    </option>
	                    <option value="female">
	                        Female
	                    </option>
	                    <option value="other">
	                        Other
	                    </option>
	                </select>
	                <br>
	                
	                <label for="Course"
	                    >Course:</label
	                >
	                <input
	                    type="radio"
	                    id="bscit"
	                    name="course"
	                    value="Bsc.IT"
	                />
	                 <label for="bscit"
	                 >Bsc.IT</label>
	                 <br>
	                 <label for="Course Subject"
	                    >Course Subject:</label
	                >
	                 <input 
		                 type="checkbox" 
		                 id="sub1" 
		                 name="sub1" 
		                 value="HTML"
		             />
		             <label for="sub1"
		             >HTML</label>
		             <input 
		                 type="checkbox" 
		                 id="sub2" 
		                 name="sub2" 
		                 value="JAVA"
		             />
		             <label for="sub2"
		             >JAVA</label>
		             <br>
	                 
	                <label for="Course"
	                    >Course:</label
	                >
	                <input
	                    type="radio"
	                    id="bcom"
	                    name="course"
	                    value="B.com"
	                />
	                 <label for="bcom"
	                 >B.com</label>
	                 <br>
	                 <label for="Course Subject"
	                    >Course Subject:</label
	                >
	                 <input 
		                 type="checkbox" 
		                 id="sub1" 
		                 name="sub1" 
		                 value="ACCOUNTS"
		             />
		             <label for="sub1"
		             >ACCOUNTS</label>
					 <input 
		                 type="checkbox" 
		                 id="sub2" 
		                 name="sub2" 
		                 value="LAW"
		             />
		             <label for="sub2"
		             >LAW</label>
		             <br>
	                <button type="submit">
	                    Submit
	                </button>
	            </form>
	        </div>
    </body>
</html>