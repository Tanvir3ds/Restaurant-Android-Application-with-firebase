import 'package:flutter/material.dart';
import 'package:eshop_flutter_app/main.dart';


class ProductDetails extends StatefulWidget {
  final product_details_name;
  final product_details_new_price;
  final product_details_old_price;
  final product_details_picture;


  ProductDetails({
      this.product_details_name,
      this.product_details_new_price,
      this.product_details_old_price,
      this.product_details_picture});
  

  @override
  _ProductDetailsState createState() => _ProductDetailsState();
}

class _ProductDetailsState extends State<ProductDetails> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: new AppBar(
        elevation: 0.1,
        backgroundColor: Colors.red,
        title: InkWell(
            onTap: (){
              Navigator.push(context, MaterialPageRoute(builder: (context)=>HomePage()));
            },
            child: Text('Shop')),
        actions: <Widget>[
          new IconButton(icon: Icon(Icons.search,color: Colors.white), onPressed: (){}),
          new IconButton(icon: Icon(Icons.shopping_cart,color: Colors.white), onPressed: (){}),
        ],
      ),

      body: new ListView(
        children: <Widget>[
          new Container(
            height: 300.0,
              child:GridTile(
                  child: Container(
                      color: Colors.white,
                      child: Image.asset(widget.product_details_picture),
            ),
                footer: new Container(
                  color: Colors.white70,
                  child: ListTile(
                    leading: new Text(widget.product_details_name,
                    style: TextStyle(fontWeight: FontWeight.bold, fontSize: 16.0),),
                    title: new Row(
                      children: <Widget>[
                        Expanded(
                         child: new Text("\$${widget.product_details_old_price}",
                         style: TextStyle(color: Colors.grey, decoration: TextDecoration.lineThrough),)
                        ),

                        Expanded(
                            child: new Text("\$${widget.product_details_new_price}",
                            style: TextStyle(color: Colors.red,fontWeight: FontWeight.w900),)
                        ),



                      ],
                    ),
                  ),
                ),
              ),
          ),

// ======================== the first button============

          Row(
            children: <Widget>[
// ====================  the buttons size  ======================
              Expanded(
                child: MaterialButton(onPressed: (){
                  showDialog(context: context,
                  builder: (context){
                    return new AlertDialog(
                      title: new Text("Size"),
                      content: new Text("Choose the size"),
                      actions: <Widget>[
                        new MaterialButton(onPressed: (){
                          Navigator.of(context).pop(context);
                        },
                        child: new Text("close"),)
                      ],
                    );
                  });
                },
                color: Colors.white,
                  textColor: Colors.grey,
                  elevation: 0.2,
                  child: Row(
                    children: <Widget>[
                      Expanded(
                        child: new Text("Size"),
                      ),

                      Expanded(
                        child: new Icon(Icons.arrow_drop_down)
                      ),
                    ],
                  ),
                ),
              ),

              //====================  the buttons size  ======================
              Expanded(
                child: MaterialButton(onPressed: (){
                  showDialog(context: context,
                      builder: (context){
                        return new AlertDialog(
                          title: new Text("Color"),
                          content: new Text("Choose the color"),
                          actions: <Widget>[
                            new MaterialButton(onPressed: (){
                              Navigator.of(context).pop(context);
                            },
                              child: new Text("close"),)
                          ],
                        );
                      });
                },
                  color: Colors.white,
                  textColor: Colors.grey,
                  elevation: 0.2,
                  child: Row(
                    children: <Widget>[
                      Expanded(
                        child: new Text("Color"),
                      ),

                      Expanded(
                          child: new Icon(Icons.arrow_drop_down)
                      ),
                    ],
                  ),
                ),
              ),

              //====================  the buttons size  ======================
              Expanded(
                child: MaterialButton(onPressed: (){
     