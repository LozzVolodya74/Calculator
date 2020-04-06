<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>

<style>
   .brd {
    border: 4px double black;
    background: pink;
    padding: 10px;
   }
</style>

<style>
.center {
	text-align: center;
}
</style>

<div class="center">
 
<div class="brd">

<h2 style="color: red;">MY CALCULATOR</h2>

<h2 style="color: blue;"> ${data } </h2>

<div class="btn-group">
  <button onclick="window.location.href = '${pageContext.request.contextPath}/data/1';">_  1   _</button>
  <button onclick="window.location.href = '${pageContext.request.contextPath}/data/2';">_  2   _</button>
  <button onclick="window.location.href = '${pageContext.request.contextPath}/data/3';">_  3   _</button>
  <button onclick="window.location.href = '${pageContext.request.contextPath}/data/u';">_ UNDO _</button>
</div> <br>

<div class="btn-group">
  <button onclick="window.location.href = '${pageContext.request.contextPath}/data/4';">_  4   _</button>
  <button onclick="window.location.href = '${pageContext.request.contextPath}/data/5';">_  5   _</button>
  <button onclick="window.location.href = '${pageContext.request.contextPath}/data/6';">_  6   _</button>
  <button onclick="window.location.href = '${pageContext.request.contextPath}/data/r';">_ REDO _</button>
</div> <br>

<div class="btn-group">
  <button onclick="window.location.href = '${pageContext.request.contextPath}/data/7';">_  7    _</button>
  <button onclick="window.location.href = '${pageContext.request.contextPath}/data/8';">_  8    _</button>
  <button onclick="window.location.href = '${pageContext.request.contextPath}/data/9';">_  9    _</button>
  <button onclick="window.location.href = '${pageContext.request.contextPath}/data/+';">___   +   ___</button>
</div> <br>

<div class="btn-group">
  <button onclick="window.location.href = '${pageContext.request.contextPath}/data/0';">_  0    _</button>
  <button onclick="window.location.href = '${pageContext.request.contextPath}/data/p';">_  .    _</button>
  <button onclick="window.location.href = '${pageContext.request.contextPath}/data/*';">_  *    _</button>
  <button onclick="window.location.href = '${pageContext.request.contextPath}/data/-';">____  -  ___</button>
</div> <br>

<div class="btn-group">
  <button onclick="window.location.href = '${pageContext.request.contextPath}/data/s';">_  /    _</button>
  <button onclick="window.location.href = '${pageContext.request.contextPath}/data/(';">_  (    _</button>
  <button onclick="window.location.href = '${pageContext.request.contextPath}/data/)';">_  )    _</button>
  <button onclick="window.location.href = '${pageContext.request.contextPath}/data/=';">___   =    ___</button>
</div> <br>

</div>

</div>