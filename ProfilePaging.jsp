<div class="container rounded bg-white mt-5 mb-5">
            <div class="row">
                <div class="col-md-5 border-right">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h4 class="text-right">Profile Settings</h4>
                        </div>
                        <div class="row mt-2">
                            <c:choose>
                                <c:when test="${editMode}">
                                    <form action="edit" method="post">
                                        <div class="col-md-6">
                                            <label class="labels">Name:</label>
                                            <input type="text" name="name" class="form-control" value="${customer.name}" />
                                        </div>
                                        <div class="col-md-6">
                                            <label class="labels">Contact_Info:</label>
                                            <input type="string" name="contact" class="form-control" value="${customer.contactInfo}" />
                                        </div>
                                        <div class="col-md-6">
                                            <label class="labels">Status: </label>
                                            <span>${customer.status}</span>
                                        </div>
                                        <div class="col-md-6">
                                            <label class="labels">Address:</label>
                                            <input type="email" name="address" class="form-control" value="${customer.address}" />
                                        </div>
                                        <div class="col-md-6">
                                            <label class="labels">Create Date: </label>
                                            <fmt:formatDate value="${registrationDate}" pattern="dd/MM/yyyy" />
                                        </div>
                                        <div class="col-md-6">
                                            <label class="labels">Email:</label>
                                            <input type="email" name="email" class="form-control" value="${user.email}" />
                                        </div>
                                        <div class="col-md-6">
                                            <label class="labels">UserName:</label>
                                            <input type="email" name="username" class="form-control" value="${user.username}" />
                                        </div>
                                        <div class="col-md-6">
                                            <label class="labels">PassWord:</label>
                                            <span>••••••••</span>
                                        </div>
                                        <button type="submit" class="btn btn-success">Save</button>
                                    </form>
                                </c:when>
                                <c:otherwise>
                                    <div class="col-md-6">
                                        <label class="labels">Name: </label>
                                        <span>${customer.name}</span>

                                    </div>
                                    <div class="col-md-6">
                                        <label class="labels">Contact_Info: </label>
                                        <span>${customer.contactInfo}</span>

                                    </div>
                                    <div class="col-md-6">
                                        <label class="labels">Status: </label>
                                        <span>${customer.status}</span>

                                    </div>
                                    <div class="col-md-6">
                                        <label class="labels">Address : </label>
                                        <span>${customer.address}</span>

                                    </div>
                                    <div class="col-md-6">
                                        <label class="labels">Create Date : </label>
                                        <fmt:formatDate value="${registrationDate}" pattern="dd/MM/yyyy" />
                                    </div>
                                </div>
                                <div class="row mt-3">
                                    <div class="col-md-12">
                                        <label class="labels">Email : </label>
                                        <span>${user.email}</span>

                                    </div>
                                    <div class="col-md-12">
                                        <label class="labels">UserName</label>
                                        <span>${user.username}</span>

                                    </div>
                                    <div class="col-md-12">
                                        <label class="labels">PassWord</label>
                                        <span>••••••••</span>
                                    </div>
                                    <div class="mt-5 text-center">
                                        <a href="edit?mode=edit" class="btn btn-primary profile-button">
                                            Edit Profile
                                        </a>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>
        </div>
