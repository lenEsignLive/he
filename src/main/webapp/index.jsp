<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Hello eSignLive</title>
</head>

<body>

<h2>Ping eSignLive</h2>

<div>This applications allows for testing connections to a eSignLive environment. Fill in the details and click on the 'Ping' button.</div>

<form method="POST" action="/he/hes">
<fieldset>
	<legend>Details:</legend>
	<label>URL:</label> <input type="text" name="url" size="60" required/><br/>
	<label>API KEY:</label> <input type="text" name="api" size="60" required/><br/>
	<label>Package ID:</label> <input type="text" name="pid" size="60" required/><br/>
	<input type="submit" value="Ping">
</fieldset>
</form>


</body>
</html>
