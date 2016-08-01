var ProductItem = React.createClass({
  render: function() {
    return ( < tr >
      < td >
      < div className = "panel panel-info" >
      < div className = "panel-heading" > {
        this.props.product.name
      } < /div> < div className = "panel-body" > {
      this.props.product.description
    } < /div> < /div > < /td>

    < /tr>
  );
}
});

var ProductList = React.createClass({
      render: function() {
        var rows = [];
        this.props.products.forEach(function(product) {
            rows.push( < ProductItem product = {
                product
              }
              key = {
                product.productId
              }
              />);
            }.bind(this));
          return ( < table className = "table table-hover" >
            < tbody > {
              rows
            } < /tbody> < /table >
          );
        }
      });


    var AddProductBar = React.createClass({

      getInitialState: function() {
        return {
          productName: '',
          productDescription: ''
        };
      },

      handleProductNameChange: function(e) {
        this.setState({
          productName: e.target.value
        });
      },

      handleProductDescChange: function(e) {
        this.setState({
          productDescription: e.target.value
        });
      },

      handleSubmit: function(e) {
        e.preventDefault();
        var name = this.state.productName.trim();
        var desc = this.state.productDescription.trim();
        if (!name || !desc) {
          return;
        }
        this.props.onUserSubmit({
          name: name,
          description: desc,
          tagList: [],
          priceList: []
        });
        this.setState({
          productName: '',
          productDescription: ''
        });

      },

      render: function() {
        return (

          < form role = "form"
          className = "form-inline"
          onSubmit = {
            this.handleSubmit
          } >
          < div className = "form-group" >
          < input className = "form-control"
          type = "text"
          placeholder = "Product name"
          value = {
            this.state.productName
          }
          onChange = {
            this.handleProductNameChange
          }
          /> < /div > < div className = "form-group" >
          < input className = "form-control"
          type = "text"
          placeholder = "Product Description"
          value = {
            this.state.productDescription
          }
          onChange = {
            this.handleProductDescChange
          }
          /> < /div > < button type = "submit"
          className = "btn btn-default" > Submit < /button> < /form >


        );
      }
    });

    var ProductTable = React.createClass({
      getInitialState: function() {
        return {
          data: []
        };
      },

      componentDidMount: function() {
        console.log('call');
        this.serverRequest = $.get(this.props.source, function(result) {
          var lastGist = result[0];
          console.log('data back');
          this.setState({
            data: result
          });
        }.bind(this));
      },

      componentWillUnmount: function() {
        this.serverRequest.abort();
      },

      handleAddProduct: function(product) {
        var products = this.state.data;

        product.productId = Date.now();
        var newProducts = products.concat([product]);
        console.log(this.state.data);
        this.setState({
          data: newProducts
        });
        console.log(this.state.data);
        // TODO: submit to the server and refresh the list
        console.log('go');
        $.ajax({
          url: '/products/',
          dataType: 'json',
          contentType: "application/json",
          type: 'POST',
          data: JSON.stringify(product),
          success: function(data) {
            // this.setState({data: data});
            console.log('Ok ');
          }.bind(this),
          error: function(xhr, status, err) {
            console.error(this.props.url, status, err.toString());
          }.bind(this)
        });
      },

      render: function() {
        return ( < div className = "panel-body" >
          < AddProductBar onUserSubmit = {
            this.handleAddProduct
          }
          /> < br / >
          < ProductList products = {
            this.state.data
          }
          /> < /div >
        );
      }
    });



    ReactDOM.render( < div className = "panel panel-default" >
      < ProductTable source = "/products/" / > < /div>,
      document.getElementById('content')
    );
