<!DOCTYPE html>
<html lang="en"><head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Moo-V | Luk up moo-v stuff</title>
        <meta name="author" content="Anthony Zheng">
        <meta name="description" content="Mehdi P3">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container-fluid" id="mainbg">
            <div class="row">
                <div class="col-xs-12 text-center">
                    <h1>Welcom 2 Moo-v site.</h1>
                    <p>wut wud u lik 2 do?</p>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 col-sm-6 col-md-3 text-center">
                    <form class="form-horizontal" action="ReqRes">
                        <label class="control-label" for="genre">Wat genre r u intereested in?</label>
                        <select class="form-control" name="genre" id="genre">
                            <option selected="selected" value="Action">Acshun</option>
                            <option value="Adventure">Adventur</option>
                            <option value="Animation">Animashin</option>
                            <option value="Comedy">Funny</option>
                            <option value="Drama">Drama</option>
                            <option value="Crime">Bad Peeple</option>
                            <option value="Fantasy">Fantasy</option>
                            <option value="Thriller">Thril</option>
                            <option value="Horror">Scary</option>
                            <option value="Family">Family</option>
                            <option value="Music">Music</option>
                            <option value="Mystery">Mystery?</option>
                            <option value="Romance">Romance</option>
                            <option value="Sci-Fi">Sci 5</option>
                            <option value="War">War</option>
                        </select>
                        <input type="hidden" name="form" value="genre">
                        <input value="submit" type="submit">
                    </form>
                </div>
                <div class="col-xs-12 col-sm-6 col-md-9 text-center">
                    <form class="form-horizontal" action="ReqRes">
                        <label class="form-control" for="title">or do u no the moo-v titel?</label>
                        <input name="title" id="title" type="text">
                        <input type="hidden" name="form" value="title">
                        <input value="submit" type="submit">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
