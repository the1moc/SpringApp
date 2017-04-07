var React = require('react');
var ReactDOM = require('react-dom');
var jQuery = require('jquery')

var baseUrl = "http://localhost:8080/api/";

var App = React.createClass({
  componentDidMount: function() {
    this.getAllShifts();
  },

  getInitialState: function () {
  return {shifts: [],
          timeValues: ["Morning", "Afternoon", "Evening"],
          dayValue: "Monday",
          timeValue: "Morning"
        };
  },

  changeDay: function(event) {
    this.setState({dayValue: event.target.value});
  },

  changeTime: function(event) {
    this.setState({timeValue: event.target.value});
  },

  getAllShifts: function() {
    var _this = this;

    $.ajax({
      url: baseUrl + "getAllShifts"
    }).then(function (data) {
      _this.setState({shifts: data});
    });
  },

  render() {
    return (
      <div className="shiftscontainer">
        <div className="shifts">
          <ShiftTable shifts={this.state.shifts} />
        </div>
        <div className="selections">
        <div className="selectionOptionsDays">
          <select value={this.state.dayValue} onChange={this.changeDay}>
            <option value="Monday">Monday</option>
            <option value="Tuesday">Tuesday</option>
            <option value="Wednesday">Wednesday</option>
            <option value="Thursday">Thursday</option>
            <option value="Friday">Friday</option>
            <option value="Saturday">Saturday</option>
            <option value="Sunday">Sunday</option>
            <option value="All days">All days</option>
           </select>
          </div>
          <div className="selectionOptionsTimes">
            <select value={this.state.timeValue} onChange={this.changeTime}>
              <option value="Morning">Morning</option>
              <option value="Afternoon">Afternoon</option>
              <option value="Evening">Evening</option>
              <option value="All times">All times</option>
             </select>
            </div>
            </div>
        </div>
      )
}
});

var Shift = React.createClass({
  render: function() {
  return (
    <tr>
      <td>{this.props.shift.firstName}</td>
      <td>{this.props.shift.lastName}</td>
      <td>{this.props.shift.day}</td>
      <td>{this.props.shift.time}</td>
    </tr>);
}
});

var ShiftTable = React.createClass({
  render: function() {
    var rows = [];
    this.props.shifts.forEach(function(shift) {
  rows.push(<Shift shift={shift} />);
});
return (
  <table>
    <thead>
      <tr>
        <th>First Name</th><th>Last name</th><th>Day</th><th>Time</th>
      </tr>
    </thead>
    <tbody>{rows}</tbody>
  </table>);
  }
});

ReactDOM.render(<App />, document.getElementById('react'));
