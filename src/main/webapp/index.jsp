<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Engine using Google CSE</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #f0f0f0;
            padding: 20px;
        }

        h1 {
            margin-bottom: 20px;
        }

        .gcse-search {
            margin: 0 auto;
            max-width: 800px; /* Increase the max-width */
            border: 1px solid #ccc;
            padding: 10px;
            border-radius: 5px;
            background-color: #fff;
        }

        input[type="text"] {
            width: 80%; /* Increase the width */
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            margin-bottom: 10px;
            background-color: #f8f8f8;
            color: #333;
            padding-left: 15px;
            padding-right: 15px;
            margin-top: 10px;
            /* Center-align the input */
            display: block;
            margin: 0 auto;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
        
        /* Style for the History button */
        button {
            background-color: #008CBA;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            margin-top: 10px;
        }

        button:hover {
            background-color: #005f79;
        }
    </style>
</head>
<body>
    <h1>Search Engine using Google Custom Search Engine</h1>
    <!-- Google Custom Search Engine code -->
    <script async src="https://cse.google.com/cse.js?cx=15a23e0601e684f76"></script>
    <div class="gcse-search"></div>
    
    <!-- History button -->
    <button onclick="window.location.href='/History'">History</button>
</body>
</html>
