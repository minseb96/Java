package hello.core.member;

import javax.swing.plaf.metal.MetalMenuBarUI;

public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);
}
