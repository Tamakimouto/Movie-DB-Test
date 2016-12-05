<!DOCTYPE html>
<html lang="en">
    <head>
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
        <div class="container-fluid">
            <div class="row">
                <div class="col-xs-12 text-center">
                    <h1>Here the moo-v reviews!</h1>
                    <#list reviews as rev>
                    <div class="row">
                        <div class="col-xs-6">
                            <div class="well">${rev.review}</div>
                            <form class="form-inline" action="ReqRes">
                                <div class="form-group">
                                    <input type="hidden" class="form-control" name="form" value="delete">
                                    <input type="hidden" class="form-control" name="cType" value="review">
                                    <input type="hidden" class="form-control" name="revId" value"${rev.id}">
                                    <input type="hidden" class="form-control" name="currMovie" value"${rev.movie_id}">
                                    <input type="submit" class="form-control" value="delet dis revew">
                                </div>
                            </form>
                        </div>
                    </div>
                    </#list>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-9">
                    <h2>U can rite ur own revew here</h2>
                    <form action="ReqRes">
                        <textarea class="form-control" name="revText" rows="3" maxlength="255">put revew here</textarea>
                        <input type="hidden" class="form-control" name="form" value="create">
                        <input type="hidden" class="form-control" name="cType" value="review">
                        <input type="hidden" class="form-control" name="currMovie" value"${id}">
                        <input type="submit" class="btn btn-primary" value="rite a rview">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
