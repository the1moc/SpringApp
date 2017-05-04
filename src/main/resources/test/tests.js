// FRONTEND TESTS (go back and make these sexier)

describe("The login page", function() {
  it("has the desired inputs", function() {
    expect($("form[name=\"f\"]")).toExist();
    expect($(":input").length).toEqual(2);
  });

  it("has a login button", function() {
    expect($(":button")).toExist();
  })
});

describe("The main application", function() {
  it("is rendered inside of a table", function() {
    expect($(".shifts")).toExist();
    expect($(".shifts table")).toExist();
  });

  it("has correctly named table headings", function() {
    expect($("thead tr").children.length).toBe(4);
    expect($("thead tr").children[0]).toEqual("First Name");
    expect($("thead tr").children[1]).toEqual("Last Name");
    expect($("thead tr").children[2]).toEqual("Day");
    expect($("thead tr").children[3]).toEqual("Time");
  });

  it("has correctly rendered select lists", funcction() {
    expect($(".selectionOptionsDays")).toExist();
    expect($(".selectionOptionsDays select").length).toBe(8);
    expect($(".selectionOptionsTimes")).toExist();
    expect($(".selectionOptionsTimes select").length).toBe(4);
  })
})
