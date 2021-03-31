<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 31/03/2021
  Time: 01:16
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
</head>
<body>

<button type="button" class="btn btn-primary" id="liveToastBtn">Show live toast</button>

<div class="position-fixed bottom-0 right-0 p-3" style="z-index: 5; right: 0; bottom: 0;">
  <div id="liveToast" class="toast hide" role="alert" aria-live="assertive" aria-atomic="true" data-delay="2000">
    <div class="toast-header">
      <img src="..." class="rounded mr-2" alt="...">
      <strong class="mr-auto">Bootstrap</strong>
      <small>11 mins ago</small>
      <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
        <span aria-hidden="true">&times;</span>
      </button>
    </div>
    <div class="toast-body">
      Hello, world! This is a toast message.
    </div>
  </div>
</div>


<div class="bs-example">
  <p><strong>Note:</strong> By default toasts will automatically hide if you do not set autohide to false.</p>

  <button type="button" class="btn btn-primary show-toast">Show Toast</button>
  <div class="toast bg-primary" id="myToast" style="position: absolute; top: 0; right: 0;" data-delay="2000">
    <div class="toast-header">
      <strong class="mr-auto"><i class="fa fa-grav"></i> We miss you!</strong>
      <small>11 mins ago</small>
      <button type="button" class="ml-2 mb-1 close" data-dismiss="toast">
        <span aria-hidden="true">&times;</span>
      </button>
    </div>
    <div class="toast-body">
      <div>It's been a long time since you visited us. We've something special for you. <a href="#">Click here!</a></div>
    </div>
  </div>
</div>

<div class="toast align-items-center text-white bg-primary border-0" role="alert" aria-live="assertive" aria-atomic="true">
  <div class="d-flex">
    <div class="toast-body">
      Hello, world! This is a toast message.
    </div>
    <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
  </div>
</div>

<div class="toast bg-primary text-light" style="position: absolute; top: 0; right: 0" data-delay="2000">
  <div class="toast-body">
    <button type="button" class="close text-light" data-dismiss="toast">
      <span>&times;</span>
    </button>
  </div>
</div>


<div class="toast align-items-center text-white bg-primary border-0" role="alert" aria-live="assertive" aria-atomic="true">
  <div class="d-flex">
    <div class="toast-body">
      Hello, world! This is a the last toast message.
    </div>
    <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
  </div>
</div>



<script>
  $('.toast').toast({'autohide': false});
  $('.toast').toast('show');
</script>

</body>
</html>