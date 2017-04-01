</div>
<!-- END #content -->

<footer>
    <div id="copyright">
        <p>
            Powered by
            <a href="http://www.jasig.org/cas" target="_blank">
                Jasig Central Authentication Service
                <%=org.jasig.cas.CasVersion.getVersion()%></a>
        </p>
    </div>
</footer>

</div>
<!-- END #container -->

<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.cookie.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-ui.min.js"></script>
<spring:theme code="cas.javascript.file" var="casJavascriptFile" text="" />
<script type="text/javascript" src="${ctx}/js/cas.js"></script>
<script type="text/javascript" src="${ctx}${casJavascriptFile}"></script>
</body>
</html>