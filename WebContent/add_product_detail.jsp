<%@include file="admin_header.jsp" %>
    <main style="height:500px">
        <div id="add-product-title">
            <h2>Add Product</h2>
        </div>
        <div id="add-product-details">
            <form action="addproduct" method="post" enctype="multipart/form-data">
                <table>
                    <tr>
                        <td>Select Category:</td>
                        <td>
                            <select name="category">
                                <option value="vegetable">Vegetable</option>
                                <option value="fruit">Fruit</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="name" placeholder="tomato/cherry"></td>
                    </tr>
                    <tr>
                        <td>Quantity:</td>
                        <td><input type="number" min="1" name="quantity" placeholder="In Kgs/Dozen"></td>
                    </tr>
                    <tr>
                        <td>Price:</td>
                        <td><input type="text" name="price"></td>
                    </tr>
                    <tr>
                        <td>Select Image:</td>
                        <td><input type="file" name="image"></td>
                    </tr>
                    <tr>
                        <td><input type="reset" value="Reset"></td>
                        <td><input type="submit" value="Submit"></td>
                    </tr>
                </table>
            </form>
        </div>
    </main>
</body>
</html>