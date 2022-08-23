<%@include file="admin_header.jsp" %>
        <main style="background-image:url('css/images/landing.jpg');background-repeat:no-repeat;background-size:cover;padding:20px;">
            <div id="admin-home-title">
                <h1>WELCOME TO <span style="color:rgb(12, 137, 12);font-size:35px;">FreshMart</span></h1>
                <h2 style="color:darkslategray">ADMIN PAGE</h2>
            </div>
            <div id="admin-home">
                <button onclick="location.href='addproduct.jsp'">Add Product</button>
                <button><a href="fetchproduct?type=fruit">View Fruit Stock</a></button>
                <button><a href="fetchproduct?type=vegetable">View Vegetable Stock</button>
                <button onclick="location.href='admin_sale_history.html'">Check Sale History</button>
                <button><a href="getquery">View Query</a></button>
            </div>
        </main>
    </div>
</body>
</html>