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
                <div class="col-xs-12">
                    <table class="table table-striped table-responsive">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Title</th>
                                <th>Year</th>
                                <th>Rank</th>
                                <th rowspan="3">Action</th>
                            </tr>
                        </thead>
                        <#list movies as movie>
                        <tr>
                            <td>${movie.id}</td>
                            <td>${movie.name}</td>
                            <td>${movie.year}</td>
                            <td>${movie.rank}</td>
                            <td>
                                <form class="form-horizontal" action="ReqRes">
                                    <input type="hidden" name="form" value="title">
                                    <input type="hidden" name="title" value="${movie.name}">
                                    <input type="submit" class="btn btn-info" value="Select">
                                </form>
                            </td>
                            <td>
                                <form class="form-horizontal" action="ReqRes">
                                    <input type="hidden" name="form" value="review">
                                    <input type="hidden" name="movieId" value="${movie.id}">
                                    <input type="submit" class="btn btn-info" value="Reviews">
                                </form>
                            </td>
                            <td>
                                <form class="form-horizontal" action="ReqRes">
                                    <input type="hidden" name="form" value="delete">
                                    <input type="hidden" name="cType" value="movie">
                                    <input type="hidden" name="movieId" value="${movie.id}">
                                    <input type="submit" class="btn btn-danger" value="Delete">
                                </form>
                            </td>
                        </tr>
                        </#list>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
