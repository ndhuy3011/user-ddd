package com.ndhuy.user.users.infrastructure.persistence;

import com.ndhuy.proto_library.user.UserProto.AuthRequest;
import com.ndhuy.proto_library.user.UserProto.AuthResponse;
import com.ndhuy.proto_library.user.UserServiceGrpc;
import com.ndhuy.user.exceptions.BadRequestException;
import com.ndhuy.user.users.application.SearchUser;

import io.grpc.stub.StreamObserver;
import jakarta.annotation.Resource;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class AuthenticatedUserGrpc extends UserServiceGrpc.UserServiceImplBase {
    @Resource
    SearchUser searchUser;

    /**
     * @ndhuy3011
     *            Authenticate function
     * @param request
     * @param responseObserver
     */
    @Override
    public void authenticate(AuthRequest request, StreamObserver<AuthResponse> responseObserver) {
        var entity = searchUser.getUsername(request.getUsername());
        if (entity == null) {
            throw new BadRequestException("ERR004");
        }
        if (!entity.getPassword().match(request.getPassword())) {
            throw new BadRequestException("ERR004");
        }

        var response = AuthResponse.newBuilder()
                .setUuid(entity.getUuid().toString())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
